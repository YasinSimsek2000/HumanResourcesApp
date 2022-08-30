<template>
  <v-card width="100%">
    <v-app-bar
        color="light-blue accent-4"
        dense
        dark
        height="100px"
    >

      <v-app-bar-nav-icon></v-app-bar-nav-icon>

        <v-toolbar-title  >

          <p class="subheading text-center" style="font-family: Calibre, serif; font-size: 30px; margin-left: 20px; margin-top: 15px"
          >HUMAN RESOURCES APPLICATION</p>
        </v-toolbar-title>

        <v-spacer></v-spacer>

        <v-btn
            v-for="(icon) in iconList"
            :key="icon.icon"
            @click="targetLink(icon.link)"
            class="mx-4"
            icon
        >
          <v-icon size="24px" color="white">
            {{ icon.icon }}
          </v-icon>
        </v-btn>

    </v-app-bar>
  </v-card>
</template>

<script>

export default {

  data () {
    return {

      icons : [
        'mdi-home',
        'mdi-bell-outline',
        'mdi-email',
        'mdi-cog-outline',
        'mdi-comment-question-outline',
      ],

      iconList: [
        {
          icon: 'mdi-home',
          link: "/main-page"
        },

        {
          icon: 'mdi-bell-outline',
          link: "/notification-page"
        },

        {
          icon: 'mdi-email',
          link: "/message-page",
        },

        {
          icon: 'mdi-cog-outline',
          link: "/settings-page"
        },

        {
          icon: 'mdi-comment-question-outline',
          link: "/support-page"
        },
      ],
    }
  },

  methods : {
    targetLink (link) {
      window.location = link;
    }
  }
}
</script>

<style>

</style>