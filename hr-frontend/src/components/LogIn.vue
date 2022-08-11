<template>
    <v-card style="display: flex; justify-content: center; margin-left: 25%; margin-right: 25%">
      <v-col style="background-color: white">

        <v-card style="display: flex; justify-content: center;">
          <v-col cols="6" style="display: flex; justify-content: center; background-color: lightblue">
            <a href="/sign-in" style="text-decoration: none;">SIGN IN</a>
          </v-col>

          <v-col cols="6" style="display: flex; justify-content: center">
            <a href="/" style="text-decoration: none;">LOG IN</a>
          </v-col>
        </v-card>

        <v-text-field
            label="E-Mail"
            :rules="rules1"
            hide-details="auto"
        ></v-text-field>

        <v-text-field
            label="Password">
          :rules="rules2"
        </v-text-field>

        <v-row>
          <v-col cols="6">
            <v-btn
                class="ma-2"
                outlined
                color="indigo"
                href="/new-password"
            >
              Forgot Your Password?
            </v-btn>
          </v-col>

          <v-col cols="6">
            <v-btn
                class="ma-2"
                outlined
                color="indigo"
                width="100%"
            >
              Log In
            </v-btn>
          </v-col>
        </v-row>
      </v-col>
    </v-card>
</template>

<script>
export default {
  data: () => ({
    rules1: [
      value => !!value || 'Required.',
      value => (value && value.includes("@") && value.includes(".com")) || 'Invalid e-mail address',
    ],

    rules2: [
      value => !!value || 'Enter at least 8 character',
      value => (value && value.length >= 8) || 'Min 8 characters',
    ],
  }),
}
</script>

<style>
</style>