<template>
  <v-row style="background-color: white;">
    <Footer></Footer>
    <v-col>
      <v-row style="min-height: 880px; width: 99%">
        <Navigation></Navigation>
        <v-col cols="3" >
          <v-data-table
              :headers="headersOfDepartmentTable"
              :items="departments"
              class="elevation-1"
              :search="search1"
          >
            <template v-slot:top>
              <v-toolbar  flat >
                <v-toolbar-title>Department</v-toolbar-title>
                <v-divider
                    class="mx-4"
                    inset
                    vertical
                ></v-divider>
                <v-spacer></v-spacer>
                <v-text-field
                    v-model="search1"
                    append-icon="mdi-magnify"
                    label="Search"
                    single-line
                    hide-details
                ></v-text-field>
                <v-spacer></v-spacer>

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
                  @click="deleteDepartment(item)"
              >
                mdi-delete
              </v-icon>
            </template>
          </v-data-table>
        </v-col>

        <v-col cols="7" >
          <v-data-table
              :headers="headersOfProjectTable"
              :items="projects"
              class="elevation-1"
              :search="search2"
          >
            <template v-slot:top>
              <v-toolbar  flat >
                <v-toolbar-title>Project</v-toolbar-title>
                <v-divider
                    class="mx-4"
                    inset
                    vertical
                ></v-divider>
                <v-spacer></v-spacer>
                <v-text-field
                    v-model="search2"
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
                                v-model="project_name"
                                label="Project Name"
                            ></v-text-field>
                          </v-col>
                          <v-col
                              cols="12"
                              sm="6"
                              md="4"
                          >
                            <v-text-field
                                v-model="startDate"
                                label="Start Date"
                            ></v-text-field>
                          </v-col>
                          <v-col
                              cols="12"
                              sm="6"
                              md="4"
                          >
                            <v-text-field
                                v-model="endDate"
                                label="End Date"
                            ></v-text-field>
                          </v-col>
                          <v-col
                              cols="12"
                              sm="6"
                              md="4"
                          >
                            <v-text-field
                                v-model="head_of_project"
                                label="Head Of Project"
                            ></v-text-field>
                          </v-col>
                          <v-col
                              cols="12"
                              sm="6"
                              md="4"
                          >
                            <v-text-field
                                v-model="newDepartment"
                                label="Departments"
                            ></v-text-field>
                          </v-col>
                          <v-col
                              cols="12"
                              sm="6"
                              md="4"
                          >
                            <v-text-field
                                v-model="newEmployeeName"
                                label="Employees"
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
                          @click="saveProject"
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
                  @click="editProject(item)"
              >
                mdi-pencil
              </v-icon>
              <v-icon
                  small
                  @click="deleteProject(item)"
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

  name: 'department-page',
  components : {
    Footer,
    Navigation
  },

  data () {
    return {
      search1: "", search2: "", sortDesc: true, sortBy: "id", dialogDelete: false, dialog: false,
      project_name: '', startDate: '', endDate: '', head_of_project: '', newEmployeeName: '', newDepartment: '',
      headersOfDepartmentTable: [
        { text: 'ID', value: 'id', align: 'start'},
        { text: 'Department Name', value: 'department_name' },
        { text: 'Number Of Employee', value: 'employee.length' },
      ],

      headersOfProjectTable: [
        { text: 'ID', value: 'id', align: 'start'},
        { text: 'Project Name', value: 'project_name' },
        { text: 'Start Date', value: 'startDate' },
        { text: 'End Date', value: 'endDate' },
        { text: 'Head Of Project', value: 'head_of_project' },
        { text: 'Employees', value: 'employees' },
        { text: 'Departments', value: 'departments'},
      ],

      departments: [],
      projects: [],

      editedIndex: -1,

      editedProject: {
        project_name: '',
        startDate: '',
        endDate: '',
        head_of_project: '',
        newEmployeeName: '',
        newDepartment: '',
      },

      defaultProject: {
        project_name: '',
        startDate: '',
        endDate: '',
        head_of_project: '',
        newEmployeeName: '',
        newDepartment: '',
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


  methods : {
    dateConverter (date) {
      return date.substring(8,10) + "/" + date.substring(5,7) + "/" + date.substring(0,4);
    },

    convertEmployeesToList (list) {
      let names = "";
      for (let j = 0; j < list.length; j++) {
        let name = list[j].name + " " + list[j].surname + ", ";
        names += name;
      } return names.substring(0,names.length-2);
    },

    convertDepartmentsToList (list) {
      let names = "";
      for (let j = 0; j < list.length; j++) {
        let name = list[j].department_name + ", ";
        names += name;
      } return names.substring(0,names.length-2);
    },

    deleteProject (item) {
      this.editedIndex = this.projects.indexOf(item);
      this.editedProject = Object.assign({}, item);
      this.dialogDelete = true;
    },

    deleteDepartment (item) {
      this.editedIndex = this.departments.indexOf(item);
      this.editedProject = Object.assign({}, item);
      this.dialogDelete = true;
    },

    deleteItemConfirm () {
      this.employees.splice(this.editedIndex, 1);
      this.closeDelete();
    },

    closeDelete () {
      this.dialogDelete = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultProject);
        this.editedIndex = -1;
      })
    },

    close () {
      this.dialog = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultProject);
        this.editedIndex = -1;
      })
    },

    saveDepartment () {
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

    saveProject () {
      this.editedProject.project_name = this.project_name;
      this.editedProject.startDate = this.startDate;
      this.editedProject.endDate = this.endDate;
      this.editedProject.head_of_project = this.head_of_project;
      this.editedProject.newDepartment = this.newDepartment;
      this.editedProject.newEmployeeName = this.newEmployeeName;

      if (this.editedIndex > -1) {
        let url = "http://localhost:8080/updateProject/" + this.projects[this.editedIndex].id;
        console.log(url);
        axios.put(url, this.editedProject).then( function () {});
        Object.assign(this.projects[this.editedIndex], this.editedProject)
      } else {
        axios.post("http://localhost:8080/createProject", this.editedProject).then( function () {});
      }

      this.close();
    },

    editProject (item) {
      this.editedIndex = this.projects.indexOf(item);
      this.editedProject = Object.assign({}, item);
      this.project_name = this.editedProject.project_name;
      this.startDate = this.editedProject.startDate;
      this.endDate = this.editedProject.endDate;
      this.head_of_project = this.editedProject.head_of_project;
      this.newEmployeeName = this.editedProject.newEmployeeName;
      this.newDepartment = this.editedProject.newDepartment;
      this.dialog = true;
    },
  },

  mounted() {
    axios.get('http://localhost:8080/getDepartments').then(response => {
      this.departments = response.data;
    });

    axios.get('http://localhost:8080/getProjects').then(response => {
      this.projects = response.data;
      for (let i = 0; i < this.projects.length; i++) {
        let startDate = this.projects[i].startDate;
        let endDate = this.projects[i].endDate;
        this.projects[i].startDate = this.dateConverter(startDate);
        this.projects[i].endDate = this.dateConverter(endDate);
        this.projects[i].head_of_project = this.projects[i].head_of_project.name + " " + this.projects[i].head_of_project.surname;
        this.projects[i].employees = this.convertEmployeesToList(this.projects[i].employees);
        this.projects[i].departments = this.convertDepartmentsToList(this.projects[i].departments);
      }
    });
  }
};
</script>

<style>

</style>