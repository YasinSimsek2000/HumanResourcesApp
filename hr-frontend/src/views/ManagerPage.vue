<template>
  <v-row style="background-color: white;">
    <Footer></Footer>
    <v-col>
      <v-row style="min-height: 880px; width: 99%">
        <Navigation></Navigation>
        <v-card
            class="mx-auto my-12"
            max-width="374"
        >
          <v-img  :src="require('../../../Human_Resources_Application_Files/Managers/'+ image)"></v-img>
          <v-card-title>{{user.name_surname}}</v-card-title>

          <v-divider class="mx-4"></v-divider>
          <v-card-title>{{user.email}}</v-card-title>
        </v-card>
        <v-card
            class="mx-auto my-12"
            width="1000"
        >
          <v-card-title>
            FILES
            <v-spacer></v-spacer>
            <template>
              <v-file-input
                  ref="uploadImage"
                  @change="onImageUpload()"
              ></v-file-input>
              <v-col cols="1"></v-col>
              <v-btn
                  color="primary"
                  dark
                  class="mb-2"
                  @click="startUpload"
              >
                Upload New Item
              </v-btn >

            </template>
          </v-card-title>
          <v-divider class="mx-4"></v-divider>
          <v-row style="margin: 10px">
            <v-col>
              <ul>
                <li
                    v-for="file in files" :key="file.id"
                >
                  {{file}}
                </li>
              </ul>
            </v-col>
          </v-row>
        </v-card>
      </v-row>
    </v-col>
  </v-row>
</template>

<script>
import Footer from '@/components/Footer.vue'
import Navigation from "@/components/Navigation";
import axios from "axios";

export default {

  name: 'manager-page',
  components : {
    Footer,
    Navigation,
  },

  data () {
    return {
      image: "",
      formData: null,

      user: {
        id: 0,
        name_surname: "",
        email: "",
      },

      files: []
    }
  },

  methods : {

    onImageUpload () {
      let file = this.$refs.uploadImage.files[0];
      this.formData = new FormData();
      this.formData.append("file", file);
    },

    startUpload () {
      let url = 'http://localhost:8080/createNewFile/Manager/' + this.user.id;
      axios.post(url, this.formData).then();
    },

    getImage (response) {
      this.image = response.data[0] + '_' +
          response.data[2] + '_' + response.data[3] + '/ProfilePhoto.png';
      console.log(this.image);
      console.log(response);
    },
  },

  created () {
    axios.get('http://localhost:8080/getCurrentUser').then(response => {
      this.user.id = response.data[0];
      this.user.email = response.data[1];
      this.user.name_surname = response.data[2] + " " + response.data[3];
      this.getImage(response);

      let url = 'http://localhost:8080/getManagerFilesByMail/' + this.user.email;
      axios.get(url).then(response => {
        for (let x = 0; x < response.data.length; x++) {
          this.files.push(response.data[x].fileName);
        }
      });
    });
  }

};
</script>