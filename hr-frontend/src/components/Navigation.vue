<template>
  <v-col cols="2">
      <v-navigation-drawer permanent height="100%" width="100%">
        <v-list>
          <v-list-item link>
            <v-list-item-avatar>
              <v-img src="https://cdn.vuetifyjs.com/images/john.png"></v-img>
            </v-list-item-avatar>
            <v-list-item-content>
              <v-list-item-title class="text-h6">
                John Leider
              </v-list-item-title>
              <v-list-item-subtitle>john@vuetifyjs.com</v-list-item-subtitle>
            </v-list-item-content>

            <v-list-item-action>
              <v-icon>mdi-menu-down</v-icon>
            </v-list-item-action>
          </v-list-item>
        </v-list>
        <v-divider></v-divider>
        <v-list
            nav
            dense
        >
          <v-list-item-group
          >
            <v-list-item
                v-for="(item, i) in items"
                :key="i"
                @click="targetLink(item.link)"
            >
              <v-list-item-icon>
                <v-icon v-text="item.icon"></v-icon>
              </v-list-item-icon>

              <v-list-item-content>
                <v-list-item-title v-text="item.text"></v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </v-list-item-group>
        </v-list>
      </v-navigation-drawer>
  </v-col>
</template>

<script>
export default {
  data () {
    return {
      items: [
        { text: 'My Files', icon: 'mdi-folder', link: '/my-files'},
        { text: 'Departments', icon: 'mdi-deskphone' , link: '/departments'},
        { text: 'Employees', icon: 'mdi-account-multiple' , link: '/employees'},
        { text: 'Projects', icon: 'mdi-apps' , link: '/projects'},
        { text: 'Uploads', icon: 'mdi-upload' , link: '/my-files'},
        { text: 'Backups', icon: 'mdi-cloud-upload' , link: '/my-files'},
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

