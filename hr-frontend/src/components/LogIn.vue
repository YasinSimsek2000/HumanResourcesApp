<template>
    <v-card style="display: flex; justify-content: center; margin-left: 25%; margin-right: 25%">
      <v-col style="background-color: white">

        <v-card style="display: flex; justify-content: center;">
          <v-col cols="6" style="display: flex; justify-content: center; background-color: lightblue">
            <a href="/sign-up" style="text-decoration: none;">SIGN UP</a>
          </v-col>

          <v-col cols="6" style="display: flex; justify-content: center">
            <a href="/" style="text-decoration: none;">LOG IN</a>
          </v-col>
        </v-card>

        <v-text-field
            type="text"
            label="E-Mail"
            :rules="rules1"
            v-model="email"
            v-on:keyup.enter="logIn"
        ></v-text-field>

        <v-text-field
            type="password"
            label="Password"
            :rules="rules2"
            v-model="password"
            v-on:keyup.enter="logIn"
          ></v-text-field>

        <v-row>
          <v-col cols="6" style="display: flex; justify-content: center">
            <v-btn
                class="ma-2"
                outlined
                color="indigo"
                href="/new-password"
                width="100%"
            >
              Forgot Your Password?
            </v-btn>
          </v-col>

          <v-col cols="6" style="display: flex; justify-content: center">
            <v-btn
                class="ma-2"
                outlined
                color="indigo"
                width="100%"
                @click="logIn"
            >
              Log In
            </v-btn>
          </v-col>
        </v-row>
      </v-col>
    </v-card>
</template>

<script>
import axios from "axios";

export default {

  data () {
    return { email:'', password: '',
      rules1: [
        value => !!value || 'Required.',
        value => (value && value.includes("@") && value.includes(".com")) || 'Invalid e-mail address',
      ],

      rules2: [
        value => !!value || 'Enter at least 8 character',
        value => (value && value.length >= 8) || 'Min 8 characters',
      ],
    }
  },

  methods : {

    isDataValid() {
      let mailValid = this.email.match("[@][A-Za-z]*.com").length === 1;
      let passwordValid = this.password.length >= 8;
      return mailValid && passwordValid;
    },

    logIn () {

      const manager = {
        email: this.email,
        password: this.password
      }

      if (this.isDataValid()) {
        axios.post('http://localhost:8080/checkManager', manager)
            .then(function (response) {
              console.log(response);
              window.location = '/mainPage';
            })

            .catch(function (error) {
              console.log(error);
              alert('Wrong e-mail address or wrong password. Please try again.')
            });

      }
    }
  },

}
</script>

<style>
</style>