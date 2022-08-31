<template>
  <v-card style="display: flex; justify-content: center; margin-left: 25%; margin-right: 25%">
    <v-col style="background-color: white">

      <v-card style="display: flex; justify-content: center;">
        <v-col cols="6" style="display: flex; justify-content: center">
          <a href="/sign-up" style="text-decoration: none;">SIGN UP</a>
        </v-col>

        <v-col cols="6" style="display: flex; justify-content: center; background-color: lightblue">
          <a href="/" style="text-decoration: none;">LOG IN</a>
        </v-col>
      </v-card>

      <v-text-field
          type="text"
          label="Name"
          hide-details="auto"
          :rules="rules0"
          v-model="name"
          v-on:keyup.enter="saveNewManager"
      ></v-text-field>

      <v-text-field
          type="text"
          label="Surname"
          hide-details="auto"
          :rules="rules0"
          v-model="surname"
          v-on:keyup.enter="saveNewManager"
      ></v-text-field>

      <v-text-field
          type="text"
          label="E-Mail"
          :rules="rules1"
          hide-details="auto"
          v-model="email"
          v-on:keyup.enter="saveNewManager"
      ></v-text-field>

      <v-text-field
          type="password"
          label="Password"
          :rules="rules2"
          v-model="newPassword"
          v-on:keyup.enter="saveNewManager"
        ></v-text-field>

      <v-row>
        <v-col cols="6">
        </v-col>

        <v-col cols="6" style="display: flex; justify-content: center">
          <v-btn
              class="ma-2"
              outlined
              color="indigo"
              width="100%"
              @click="saveNewManager"
          >
            SIGN UP
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
    return { name : '', surname : '', email : '', newPassword : '',

      rules0: [
        value => !!value || 'Required.',
      ],

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
      let nameValid = this.name.length > 0;
      let surnameValid = this.surname.length > 0;
      let mailValid = this.email.match("[@][A-Za-z]*.com").length === 1;
      let passwordValid = this.newPassword.length >= 8;
      return nameValid && surnameValid && mailValid && passwordValid;
    },

    saveNewManager () {

      const manager = {
        email: this.email,
        name: this.name,
        password: this.newPassword,
        surname: this.surname
      }

      if (this.isDataValid()) {
        axios.post('http://localhost:8080/createManager', manager )
            .then(function (response) {
              console.log(response);
              axios.post('http://localhost:8080/sendMail', {
                recipient: manager.email,
                messageBody: 'We are happy you joined us. Your account data:\nName: ' + manager.name + '\nSurname: '
                              + manager.surname + '\nPassword: ' + manager.password,
                subject :'Welcome to Human Resources Application!'
              })
                  .then(function () {
                    alert('Account was created successfully!');
                    window.location = '/home';
                  })
                  .catch(function (error) {
                    console.log(error);
                  });
            })

            .catch(function (error) {
              console.log(error);
            });
      }

      else {
        alert('Please check the data you enter');
      }
    }

  }
}
</script>

<style>
</style>