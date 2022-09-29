<template>
  <v-row style="background-color: white;">
    <Footer></Footer>
    <v-col>
      <v-row style="min-height: 880px; width: 99%">
        <Navigation></Navigation>
        <v-card
            class="mx-auto my-12"
            width="400px"
        >
          <v-card-title>SEND MESSAGE</v-card-title>
          <v-divider class="mx-4"></v-divider>
          <v-container fluid>
            <v-textarea
                label="Message"
                v-model="message"
            ></v-textarea>
          </v-container>
          <v-container>
            <v-text-field label="To" v-model="to"></v-text-field>
          </v-container>
          <v-container>
            <v-text-field label="Title" v-model="subject"></v-text-field>
          </v-container>
          <v-container>
            <v-btn
                color="primary"
                dark
                class="mb-2"
                @click="sendMessage"
            >
              SEND
            </v-btn >
          </v-container>
        </v-card>
        <v-card
            class="mx-auto my-12"
            width="800px"
        >
          <v-card-title>
            NOTIFICATIONS
            <v-spacer></v-spacer>
          </v-card-title>
          <v-divider class="mx-4"></v-divider>
          <v-row style="margin: 10px">
            <v-col>
              <ul>
                <li
                    v-for="notification in notifications" :key="notification.id"
                >
                  <h3>{{notification.title}}</h3>
                  <p>{{notification.messageText}}</p>
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

  name: 'notification-page',
  components : {
    Footer,
    Navigation,
  },

  data () {
    return {
      to: 0, message: "", subject: "",
      user: {
        id: 0,
        name_surname: "",
        email: "",
      },

      notifications: []
    }
  },

  methods : {

    sendMessage () {
      const notification = {
        messageTitle: this.subject,
        messageText: this.message,
        messageFrom: this.user.name_surname
      }

      let url = 'http://localhost:8080/newMessage/' + this.to;
      axios.post(url, notification).then();
    }
  },

  created () {
    axios.get('http://localhost:8080/getCurrentUser').then(response => {
      this.user.id = response.data[0];
      this.user.email = response.data[1];
      this.user.name_surname = response.data[2] + " " + response.data[3];

      let url = 'http://localhost:8080/getMessages/' + this.user.id;
      axios.get(url).then(response => this.notifications = response.data)
    });
  }

};
</script>