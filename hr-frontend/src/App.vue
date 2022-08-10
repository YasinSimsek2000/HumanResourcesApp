<template>
  <v-row>
    <v-col>
      <HeadOfPage1 ></HeadOfPage1>
      <LogIn></LogIn>
    </v-col>
  </v-row>
</template>

<script>
import HeadOfPage1 from '@/components/HeadOfPage1.vue'
import LogIn from '@/components/LogIn.vue'

export default {

  name: 'app',
  components : {
    LogIn,
    HeadOfPage1,
  }
};
</script>

<style>

</style>
