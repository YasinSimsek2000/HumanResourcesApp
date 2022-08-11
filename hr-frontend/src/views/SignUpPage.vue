<template>
  <v-row>
    <v-col>
      <HeadOfPage1 ></HeadOfPage1>
      <SignUp ></SignUp>
    </v-col>
  </v-row>
</template>

<script>
import HeadOfPage1 from '@/components/HeadOfPage1.vue'
import SignUp from '@/components/SignUp.vue'

export default {

  name: 'sign-in',
  components : {
    SignUp,
    HeadOfPage1,
  }
};
</script>

<style>

</style>
