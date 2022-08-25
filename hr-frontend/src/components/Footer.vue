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
        <v-card-title  >

          <img :src="iconLogo" class="logo" width="50px" height="50px">
          <p class="subheading text-center" style="font-family: Calibre, serif; font-size: 30px; margin-left: 20px; margin-top: 15px"
          >HUMAN RESOURCES APPLICATION</p>

          <v-spacer></v-spacer>

          <v-btn
              v-for="(icon) in iconList"
              :key="icon.icon"
              @click="icon.onClick()"
              class="mx-4"
              icon
          >
            <v-icon size="24px" color="white">
              {{ icon.icon }}
            </v-icon>
          </v-btn>
        </v-card-title>

        <v-divider></v-divider>
      </v-card>
    </v-footer>
  </v-card>
</template>

<script>

import logoImage from "@/components/HRlogo.png"
export default {

  data () {
    return {
      iconList: [
        {
          icon: 'mdi-home',
          onClick: () => {
            window.location = "/main-page";
          }
        },
        {
          icon: 'mdi-bell-outline',
          onClick: () => {
            window.location = "/notification-page";
          }
        },
        {
          icon: 'mdi-email',
          onClick: () => {
            window.location = "/message-page";
          }
        },
        {
          icon: 'mdi-cog-outline',
          onClick: () => {
            window.location = "/settings-page";
          }
        },
        {
          icon: 'mdi-comment-question-outline',
          onClick: () => {
            window.location = "/support-page";
          }
        },
      ],

      iconLogo: logoImage,
    }
  }
}
</script>

<style>

</style>