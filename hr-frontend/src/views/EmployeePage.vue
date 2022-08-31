<template>
  <v-row style="background-color: white;">
    <Footer></Footer>
    <v-col>
      <v-row style="min-height: 880px; width: 99%">
        <Navigation></Navigation>
        <v-col cols="10" >
          <p class="subheading" style="font-family: Calibre, serif; font-size: 30px;margin-top: 15px"
          >EMPLOYEES</p>

          <v-data-table
              :headers="headers"
              :items="employees"
              :items-per-page="10"
              class="elevation-1"
          ></v-data-table>

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
        { text: 'Department', value: 'department'}
      ],
      employees: [],
    }
  },

  methods : {
  },

  mounted() {
    axios.get('http://localhost:8080/getEmployees').then(response => {
      response.data.department = "";
      this.employees = response.data;
      for (let i = 0; i < this.employees.length; i++) {
        let url = 'http://localhost:8080/getDepartmentOfEmployee/' + this.employees[i].id.toString();
        axios.get(url).then(response1 => {
          this.employees[i].department = response1.data.department_name;
        });
        let date = this.employees[i].birth_date;
        this.employees[i].birth_date = date.substring(8,10) + "/" + date.substring(5,7) + "/" + date.substring(0,4);
      }
    });
  },
};
</script>

<style>

</style>