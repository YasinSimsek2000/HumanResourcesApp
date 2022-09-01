<template>
  <v-row style="background-color: white;">
    <Footer></Footer>
    <v-col>
      <v-row style="min-height: 880px; width: 99%">
        <Navigation></Navigation>
        <v-col cols="10" >
          <v-card>
            <v-card-title>
              EMPLOYEES
              <v-spacer></v-spacer>
              <v-text-field
                  v-model="search"
                  append-icon="mdi-magnify"
                  label="Search"
                  single-line
                  hide-details
              ></v-text-field>
            </v-card-title>
            <v-data-table
                :headers="headers"
                :items="employees"
                :search="search"
            ></v-data-table>
          </v-card>

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
      search: "",
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
        { text: 'Project', value: 'project'}
      ],
      employees: [],
    }
  },

  methods : {
    dateConverter (date) {
      return date.substring(8,10) + "/" + date.substring(5,7) + "/" + date.substring(0,4);
    }
  },

  created() {
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
};
</script>

<style>

</style>