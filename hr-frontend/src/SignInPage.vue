<template>
  <v-row>
    <v-col>
      <HeadOfPage1 ></HeadOfPage1>
      <SignIn ></SignIn>
    </v-col>
  </v-row>
</template>

<script>
import HeadOfPage1 from '@/components/HeadOfPage1.vue'
import SignIn from '@/components/SignIn.vue'

export default {

  name: 'sign-in',
  components : {
    SignIn,
    HeadOfPage1,
  }
};
</script>

<style>

</style>
