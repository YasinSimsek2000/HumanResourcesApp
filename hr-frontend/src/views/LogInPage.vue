<template>
  <v-row>
    <v-col

        class="container text-center"
        v-for="n in 1"
        :key="n"
        cols="4">

        <v-list-item>
          <v-list-item-content>
            <v-list-item-title style="color: crimson; font-size: 20px;">PLEASE ENTER USER INFORMATIONS</v-list-item-title>
          </v-list-item-content>
        </v-list-item>


        <v-text-field
            outlined
            placeholder="Your E-Mail"
            id="email"
            background-color="light-blue lighten-5"
            border-color="light-blue lighten-5"
        ></v-text-field>

        <v-text-field
              outlined
              placeholder="Your Password"
              id="password"
              background-color="light-blue lighten-5"
              border-color="light-blue lighten-5"
        ></v-text-field>

      <v-row>
        <v-col cols="6">
            <a href="" style="color: dodgerblue" >Forgot Password?</a>
        </v-col>

        <v-col cols="6">

        </v-col>
      </v-row>

    </v-col>
  </v-row>
</template>

<script>

export default {
  name: "log-in",
}
</script>

