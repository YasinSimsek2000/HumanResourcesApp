<template>
  <v-row style="background-color: white;">
    <Footer></Footer>
    <v-col>
      <v-row style="min-height: 880px; width: 99%">
        <Navigation></Navigation>
        <v-col cols="10">
          <v-row>
            <v-col cols="6">
              <v-img style="height: 300px; width: 300px;" :src="image"></v-img>
            </v-col>


          </v-row>
        </v-col>
      </v-row>
    </v-col>
  </v-row>
</template>

<script>
import Footer from '@/components/Footer.vue'
import Navigation from "@/components/Navigation";

export default {

  name: 'manager-page',
  components : {
    Footer,
    Navigation,
  },

  data () {
    return {
      image: "", items: [],
    }
  },

  created() {

  }

};
</script>

<style>

</style>