<template>
  <v-row style="background-color: white;">
    <Footer></Footer>
    <v-col>
      <v-row style="min-height: 880px; width: 99%">
        <Navigation></Navigation>
        <v-col cols="10" >
            <v-data-table
                :headers="headers"
                :items="employees"
                class="elevation-1"
                :search="search"
            >
              <template v-slot:top>
                <v-toolbar  flat >
                  <v-toolbar-title>Employee</v-toolbar-title>
                  <v-divider
                      class="mx-4"
                      inset
                      vertical
                  ></v-divider>
                  <v-spacer></v-spacer>
                  <v-text-field
                      v-model="search"
                      append-icon="mdi-magnify"
                      label="Search"
                      single-line
                      hide-details
                  ></v-text-field>
                  <v-spacer></v-spacer>
                  <v-dialog
                      v-model="dialog"
                      max-width="800px"
                  >
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                          color="primary"
                          dark
                          class="mb-2"
                          v-bind="attrs"
                          v-on="on"
                      >
                        New Item
                      </v-btn>
                    </template>
                    <v-card>
                      <v-card-title>
                        <span class="text-h5">{{ formTitle }}</span>
                      </v-card-title>

                      <v-card-text>
                        <v-container>
                          <v-row>
                            <v-col
                                cols="12"
                                sm="6"
                                md="4"
                            >
                              <v-text-field
                                  v-model="name"
                                  label="Name"
                              ></v-text-field>
                            </v-col>
                            <v-col
                                cols="12"
                                sm="6"
                                md="4"
                            >
                              <v-text-field
                                  v-model="surname"
                                  label="Surname"
                              ></v-text-field>
                            </v-col>
                            <v-col
                                cols="12"
                                sm="6"
                                md="4"
                            >
                              <v-text-field
                                  v-model="birth_date"
                                  label="Birth Date"
                              ></v-text-field>
                            </v-col>
                            <v-col
                                cols="12"
                                sm="6"
                                md="4"
                            >
                              <v-text-field
                                  v-model="age"
                                  label="Age"
                              ></v-text-field>
                            </v-col>
                            <v-col
                                cols="12"
                                sm="6"
                                md="4"
                            >
                              <v-text-field
                                  v-model="address"
                                  label="Address"
                              ></v-text-field>
                            </v-col>
                            <v-col
                                cols="12"
                                sm="6"
                                md="4"
                            >
                              <v-text-field
                                  v-model="email"
                                  label="E-Mail"
                              ></v-text-field>
                            </v-col>
                            <v-col
                                cols="12"
                                sm="6"
                                md="4"
                            >
                              <v-text-field
                                  v-model="marital_status"
                                  label="Marital Status"
                              ></v-text-field>
                            </v-col>
                            <v-col
                                cols="12"
                                sm="6"
                                md="4"
                            >
                              <v-text-field
                                  v-model="mobile"
                                  label="Mobile"
                              ></v-text-field>
                            </v-col>
                            <v-col
                                cols="12"
                                sm="6"
                                md="4"
                            >
                              <v-text-field
                                  v-model="salary"
                                  label="Salary"
                              ></v-text-field>
                            </v-col>
                            <v-col
                                cols="12"
                                sm="6"
                                md="4"
                            >
                              <v-text-field
                                  v-model="title"
                                  label="Title"
                              ></v-text-field>
                            </v-col>
                            <v-col
                                cols="12"
                                sm="6"
                                md="4"
                            >
                              <v-text-field
                                  v-model="department"
                                  label="Department"
                              ></v-text-field>
                            </v-col>
                            <v-col
                                cols="12"
                                sm="6"
                                md="4"
                            >
                              <v-text-field
                                  v-model="project"
                                  label="Project"
                              ></v-text-field>
                            </v-col>
                          </v-row>
                        </v-container>
                      </v-card-text>

                      <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn
                            color="blue darken-1"
                            text
                            @click="close"
                        >
                          Cancel
                        </v-btn>
                        <v-btn
                            color="blue darken-1"
                            text
                            @click="save"
                        >
                          Save
                        </v-btn>
                      </v-card-actions>
                    </v-card>
                  </v-dialog>
                  <v-dialog v-model="dialogDelete" max-width="500px">
                    <v-card>
                      <v-card-title class="text-h5">Are you sure you want to delete this item?</v-card-title>
                      <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn color="blue darken-1" text @click="closeDelete">Cancel</v-btn>
                        <v-btn color="blue darken-1" text @click="deleteItemConfirm">OK</v-btn>
                        <v-spacer></v-spacer>
                      </v-card-actions>
                    </v-card>
                  </v-dialog>
                </v-toolbar>
              </template>
              <template v-slot:[`item.actions`]="{ item }">
                <v-icon
                    small
                    class="mr-2"
                    @click="editItem(item)"
                >
                  mdi-pencil
                </v-icon>
                <v-icon
                    small
                    @click="deleteItem(item)"
                >
                  mdi-delete
                </v-icon>
              </template>
            </v-data-table>
        </v-col>
      </v-row>
    </v-col>

  </v-row>

</template>

<script>

import Footer from '@/components/Footer.vue'
import Navigation from "@/components/Navigation";
import axios from "axios";

export default {

  name: 'employee-page',
  components : {
    Footer,
    Navigation
  },

  data () {
    return {
      dialog: false,  dialogDelete: false,
      name: '', surname: '', birth_date: null, age: '', address: '', email: '', marital_status: '', mobile: '',
      salary: '', title: '', department: null, project: null, search: "",

      headers: [
        { text: 'ID', value: 'id', align: 'start'},
        { text: 'Name', value: 'name'},
        { text: 'Surname', value: 'surname'},
        { text: 'Birth Date', value: 'birth_date'},
        { text: 'Age', value: 'age'},
        { text: 'Address', value: 'address' },
        { text: 'E-Mail', value: 'email' },
        { text: 'Marital Status', value: 'marital_status' },
        { text: 'Mobile', value: 'mobile' },
        { text: 'Salary', value: 'salary' },
        { text: 'Title', value: 'title'},
        { text: 'Department', value: 'department'},
        { text: 'Project', value: 'project'},
        { text: 'Actions', value: 'actions', sortable: false },
      ],

      employees: [],
      editedIndex: -1,

      editedItem: {
        name: '',
        surname: '',
        birth_date: null,
        age: '',
        address: '',
        email: '',
        marital_status: '',
        mobile: '',
        salary: '',
        title: '',
        department: null,
        project: null,
      },

      defaultItem: {
        name: '',
        surname: '',
        birth_date: '',
        age: '',
        address: '',
        email: '',
        marital_status: '',
        mobile: '',
        salary: '',
        title: '',
        department: '',
        project: '',
      },

    }
  },

  computed: {
    formTitle () {
      return this.editedIndex === -1 ? 'New Item' : 'Edit Item';
    },
  },

  watch: {
    dialog (val) {
      val || this.close();
    },
    dialogDelete (val) {
      val || this.closeDelete();
    },
  },

  created () {
    this.initialize();
  },

  methods: {
    initialize () {
      axios.get('http://localhost:8080/getEmployees').then(response => {
        this.employees = response.data;
        for (let i = 0; i < this.employees.length; i++) {
          let url_d = 'http://localhost:8080/getDepartmentOfEmployee/' + this.employees[i].id.toString();
          let url_p = 'http://localhost:8080/getProjectOfEmployee/' + this.employees[i].id.toString();
          axios.get(url_d).then(response1 => { this.employees[i].department = response1.data.department_name; });
          axios.get(url_p).then(response2 => { this.employees[i].project = response2.data.project_name; });
          let date = this.employees[i].birth_date;
          this.employees[i].birth_date = this.dateConverter(date);
        }
      });
    },

    dateConverter (date) {
      return date.substring(8,10) + "/" + date.substring(5,7) + "/" + date.substring(0,4);
    },

    editItem (item) {
      this.editedIndex = this.employees.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.name = this.editedItem.name;
      this.surname = this.editedItem.surname;
      this.birth_date = this.editedItem.birth_date;
      this.age = this.editedItem.age;
      this.address = this.editedItem.address;
      this.email = this.editedItem.email;
      this.marital_status = this.editedItem.marital_status;
      this.mobile = this.editedItem.mobile;
      this.salary = this.editedItem.salary;
      this.title = this.editedItem.title;
      this.department = this.editedItem.department;
      this.project = this.editedItem.project;
      this.dialog = true;
    },

    deleteItem (item) {
      this.editedIndex = this.employees.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.dialogDelete = true;
    },

    deleteItemConfirm () {
      this.employees.splice(this.editedIndex, 1);
      this.closeDelete();
    },

    close () {
      this.dialog = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      })
    },

    closeDelete () {
      this.dialogDelete = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      })
    },

    save () {
      this.editedItem.name = this.name;
      this.editedItem.surname = this.surname;
      this.editedItem.birth_date = this.birth_date;
      this.editedItem.age = this.age;
      this.editedItem.address = this.address;
      this.editedItem.email = this.email;
      this.editedItem.marital_status = this.marital_status;
      this.editedItem.mobile = this.mobile;
      this.editedItem.salary = this.salary;
      this.editedItem.title = this.title;
      this.editedItem.department = this.department;
      this.editedItem.project = this.project;

      if (this.editedIndex > -1) {
        let url = "http://localhost:8080/updateEmployee/" + this.employees[this.editedIndex].id;
        console.log(url);
        axios.put(url, this.editedItem).then( function () {});
        Object.assign(this.employees[this.editedIndex], this.editedItem)
      } else {
        axios.post("http://localhost:8080/createEmployee", this.editedItem).then( function () {});
      }
      this.initialize();
      this.close();
    },
  },
}
</script>
