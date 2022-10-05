<template>
  <v-col cols="2">
      <v-navigation-drawer permanent height="100%" width="100%">
        <v-list>
          <v-list-item link>
            <v-list-item-avatar>
              <v-img :src="require('../../../Human_Resources_Application_Files/Managers/'+ image)"></v-img>
            </v-list-item-avatar>
            <v-list-item-content @click="targetLink('/manager')">
              <v-list-item-title class="text-h6" v-model="name_surname"> {{name_surname}}</v-list-item-title>
              <v-list-item-subtitle v-model="mail"> {{mail}}</v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>
        </v-list>
        <v-divider></v-divider>
        <v-list
            nav
            dense
        >


          <v-list-item-group
          >
            <v-list-item
                v-for="(item, i) in items"
                :key="i"
                @click="targetLink(item.link)"
            >
              <v-list-item-icon>
                <v-icon v-text="item.icon"></v-icon>
              </v-list-item-icon>

              <v-list-item-content>
                <v-list-item-title v-text="item.text"></v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </v-list-item-group>
        </v-list>
      </v-navigation-drawer>
  </v-col>
</template>

<script>

import axios from "axios";

export default {
  data () {
    return {
      mail: "", name_surname: "", image: '',

      items: [
        { text: 'My Files', icon: 'mdi-folder', link: '/my-files'},
        { text: 'Departments and Projects', icon: 'mdi-apps' , link: '/departments-projects'},
        { text: 'Employees', icon: 'mdi-account-multiple' , link: '/employees'},
        { text: 'Uploads', icon: 'mdi-upload' , link: '/my-files'},
        { text: 'Backups', icon: 'mdi-cloud-upload' , link: '/my-files'},
      ],
    }
  },

  methods : {
    targetLink (link) {
      window.location = link;
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
      this.mail = response.data[1];
      this.name_surname = response.data[2] + " " + response.data[3];
      this.getImage(response);
    });
  }
}
</script>
