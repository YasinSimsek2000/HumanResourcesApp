<template>

  <v-card style="display: flex; justify-content: center; margin-left: 25%; margin-right: 25%">


    <v-col style="justify-content: center; margin-top: 30px; margin-bottom: 10px">
      <h2 style="text-align: center">Forgot Password</h2>
      <p style="text-align: center">No Problem! Enter your email or username below and we will send you an email with instruction to reset your password.</p>
      <p style="text-align: center; font-weight: bold" >If you have an account, you will get an e-mail.</p>
      <v-row>
        <v-col cols="7">
          <v-text-field
              label="E-Mail"
              :rules="rules1"
              hide-details="auto"
          ></v-text-field>
        </v-col>

        <v-col cols="5">
          <v-btn
              class="ma-2"
              outlined
              color="indigo"
              @click="enterPassword"
          >
            Send Reset E-Mail
          </v-btn>
        </v-col>
      </v-row>

      <v-row  v-if="buttonClicked">
        <v-col cols="7">
          <v-text-field
              label="Enter the password in e-mail"
              hide-details="auto"
          ></v-text-field>
        </v-col>

        <v-col cols="5">
          <v-btn
              class="ma-2"
              outlined
              color="indigo"
              width="95%"
          >
            Confirm
          </v-btn>
        </v-col>
      </v-row>
    </v-col>
  </v-card>
</template>

<script>
export default {

  data () {
    return { buttonClicked: false }
  },

  rules1: [
    value => !!value || 'Required.',
    value => (value && value.includes("@") && value.includes(".com")) || 'Invalid e-mail address',
  ],

  methods: {
    enterPassword () {
      this.buttonClicked = true;
    },
  }
}
</script>

<style>
h1, h3 {
  font-family: Calibri, serif;
  text-align: center;
}
</style>