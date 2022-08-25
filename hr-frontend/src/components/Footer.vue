<template>
  <v-card width="100%">
    <v-footer
      dark
      padless
    >
      <v-card
          flat
          tile
          width="100%"
          class="flex light-blue"
      >
        <v-card-title height="250px">

          <v-icon>

          </v-icon>
          <strong class="subheading text-center">Get connected with us on social networks!</strong>

          <v-spacer></v-spacer>

          <v-btn
              v-for="icon in icons"
              :key="icon"
              class="mx-4"
              icon
          >
            <v-icon size="24px" color="white">
              {{ icon }}
            </v-icon>
          </v-btn>
        </v-card-title>

        <v-divider></v-divider>
      </v-card>
    </v-footer>
  </v-card>
</template>

<script>
export default {

  data () {
    return {
      icons: [
        'mdi-home',
        'mdi-bell-outline',
        'mdi-email',
        'mdi-cog-outline',
        'mdi-comment-question-outline'
      ],
    }
  }
}
</script>

<style>

</style>