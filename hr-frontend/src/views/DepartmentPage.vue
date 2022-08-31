<template>
  <v-row style="background-color: white;">
    <Footer></Footer>
    <v-col>
      <v-row style="min-height: 880px; width: 99%">
        <Navigation></Navigation>
        <v-col cols="10" >
          <p class="subheading" style="font-family: Calibre, serif; font-size: 30px;margin-top: 15px"
          >DEPARTMENTS</p>

          <v-data-table
              :headers="headers"
              :items="departments"
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

  name: 'department-page',
  components : {
    Footer,
    Navigation
  },

  data () {
    return {
      headers: [
        { text: 'ID', value: 'id', align: 'start'},
        { text: 'Department Name', value: 'department_name' },
        { text: 'Number Of Employee', value: 'employee.length' },
      ],
      departments: [],
    }
  },



  mounted() {
    axios.get('http://localhost:8080/getDepartments').then(response => {
      this.departments = response.data;
    });
  }
};
</script>

<style>

</style>