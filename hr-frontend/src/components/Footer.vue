<template>
  <v-card width="100%">
    <v-app-bar
        color="light-blue accent-4"
        dense
        dark
        height="100px"
    >

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
          link: "/home"
        },

        {
          icon: 'mdi-bell-outline',
          link: "/notifications"
        },

        {
          icon: 'mdi-email',
          link: "/messages",
        },

        {
          icon: 'mdi-cog-outline',
          link: "/settings"
        },

        {
          icon: 'mdi-comment-question-outline',
          link: "/support"
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