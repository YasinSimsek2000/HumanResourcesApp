<template>

  <v-card style="display: flex; justify-content: center; margin-left: 25%; margin-right: 25%">


    <v-col style="justify-content: center; margin-top: 30px; margin-bottom: 10px">
      <h2 style="text-align: center">Forgot Password</h2>
      <p style="text-align: center">No Problem! Enter your email or username below and we will send you an email with instruction to reset your password.</p>
      <p style="text-align: center; font-weight: bold" >If you have an account, you will get an e-mail.</p>
      <v-row>
        <v-col cols="8">
          <v-text-field
              label="E-Mail"
              :rules="rules1"
              hide-details="auto"
              v-model="email"
          ></v-text-field>
        </v-col>

        <v-col cols="4" style="display: flex; justify-content: center">
          <v-btn
              class="ma-2"
              outlined
              color="indigo"
              @click="setValid(); sendCode()"
              width="100%"
          >
            Send Reset E-Mail
          </v-btn>
        </v-col>
      </v-row>

      <v-row  v-if="buttonClicked">
        <v-col cols="8">
          <v-text-field
              label="Enter the password in e-mail"
              hide-details="auto"
              v-model="code"
          ></v-text-field>
        </v-col>

        <v-col cols="4" style="display: flex; justify-content: center">
          <v-btn
              class="ma-2"
              outlined
              color="indigo"
              width="100%"
              @click="confirm"
          >
            Confirm
          </v-btn>
        </v-col>
      </v-row>

      <v-row  v-if="confirmPassed">
        <v-col cols="4">
          <v-text-field
              label="Enter new password"
              hide-details="auto"
              v-model="newPassword"
              :rules="rules2"
          ></v-text-field>
        </v-col>

        <v-col cols="4">
          <v-text-field
              label="Enter new password again"
              hide-details="auto"
              v-model="newPasswordAgain"
              :rules="rules2"
          ></v-text-field>
        </v-col>

        <v-col cols="4" style="display: flex; justify-content: center">
          <v-btn
              class="ma-2"
              outlined
              color="indigo"
              width="100%"
              @click="saveNewPassword"
          >
            SAVE
          </v-btn>
        </v-col>
      </v-row>
    </v-col>
  </v-card>
</template>

<script>
import axios from 'axios';
let number;
export default {

  data () {
    return { buttonClicked: false ,email : '', code : '', confirmPassed: false, newPassword : '', newPasswordAgain : '',
      rules1: [
        value => !!value || 'Required.',
        value => (value && value.includes("@") && value.includes(".com")) || 'Invalid e-mail address',
      ],

      rules2 : [
          value => (value.length >= 8) || 'It must be include at least 8 character!',
      ],
    }
  },

  methods: {

    setValid () {
      let result = this.email.match("[@][A-Za-z]*.com");
      if (result.length === 1) {
        this.buttonClicked = true;
      }
    },

    isMailValid () {
      return this.buttonClicked;
    },

    sendCode () {
      if (this.isMailValid()) {
        number = Math.floor(Math.random() * 999999) + 100000;
        axios.post('http://localhost:8080/sendMail', {
          recipient: this.email,
          messageBody: 'Enter this code to continue: ' + number,
          subject :'Forgot Your Password?'
        })
            .then(function (response) {
              console.log(response);
            })
            .catch(function (error) {
              console.log(error);
            });
      }

      console.log(number);

    },

    confirm () {
      this.code = (parseInt(this.code) === number) ? true : 'Wrong Code!';
      if (this.code === true) {
        this.buttonClicked = false;
        this.confirmPassed = true;
      }
    },

    saveNewPassword () {

      const manager = {
        email: this.email,
        password: this.newPassword
      }

      if (this.newPassword === this.newPasswordAgain) {
        axios.put('http://localhost:8080/updateManager', manager)
            .then(function (response) {
              console.log(response);
            })
            .catch(function (error) {
              console.log(error);
            });

        alert('You can continue with your new password.');
        window.location = "/";
      }

      else {
        alert('Try again! The passwords do not pair.');


      }
    }
  }
}
</script>

<style>
h1, h3 {
  font-family: Calibri, serif;
  text-align: center;
}
</style>