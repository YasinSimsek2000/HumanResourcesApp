<template>
  <v-row style="background-color: white;">
    <Footer></Footer>
    <v-col>
      <v-row style="min-height: 880px">
        <Navigation></Navigation>
        <v-col cols="10">

        </v-col>
      </v-row>
    </v-col>

  </v-row>

</template>

<script>
import Footer from '@/components/Footer.vue'
import Navigation from "@/components/Navigation";

export default {

  name: 'home-page',
  components : {
    Footer,
    Navigation
  }
};
</script>

<style>

</style>