<template>
  <v-row style="background-color: white;">
    <Footer></Footer>
    <v-col>
      <v-row style="min-height: 880px; width: 99%">
        <Navigation></Navigation>
        <v-col cols="3" >
          <v-card>
            <v-card-title>
              DEPARTMENTS
              <v-spacer></v-spacer>
              <v-text-field
                  v-model="search1"
                  append-icon="mdi-magnify"
                  label="Search"
                  single-line
                  hide-details
              ></v-text-field>
            </v-card-title>
            <v-data-table
                :headers="headersOfDepartmentTable"
                :items="departments"
                :search="search1"
            ></v-data-table>
          </v-card>
        </v-col>

        <v-col cols="7" >
          <v-card>
            <v-card-title>
              PROJECTS
              <v-spacer></v-spacer>
              <v-text-field
                  v-model="search2"
                  append-icon="mdi-magnify"
                  label="Search"
                  single-line
                  hide-details
              ></v-text-field>
            </v-card-title>
            <v-data-table
                :headers="headersOfProjectTable"
                :items="projects"
                :search="search2"
                :sort-by="sortBy"
                :sort-desc.sync="sortDesc"
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

  name: 'department-page',
  components : {
    Footer,
    Navigation
  },

  data () {
    return {
      search1: "", search2: "", sortDesc: true, sortBy: "id",
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
    }
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
    }
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