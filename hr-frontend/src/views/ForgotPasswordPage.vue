<template>
  <v-row>
    <v-col>
      <HeadOfPage1 ></HeadOfPage1>
      <Forgot></Forgot>
    </v-col>
  </v-row>
</template>

<script>
import HeadOfPage1 from '@/components/HeadOfPage1.vue'
import Forgot from "@/components/ForgotPassword";

export default {

  name: 'new-password',
  components : {
    HeadOfPage1,
    Forgot,
  }
};
</script>

<style>

</style>