<template>
  <v-row>
    <v-col>
      <HeadOfPage1 ></HeadOfPage1>
      <ForgotPassword></ForgotPassword>
    </v-col>
  </v-row>
</template>

<script>
import HeadOfPage1 from '@/components/HeadOfPage1.vue'
import ForgotPassword from "@/components/ForgotPassword";

export default {

  name: 'new-password',
  components : {
    HeadOfPage1,
    ForgotPassword,
  }
};
</script>

<style>

</style>