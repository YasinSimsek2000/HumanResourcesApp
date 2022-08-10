import Vue from 'vue'
import VueRouter from 'vue-router'
import App from "@/App";
import SignInPage from "@/SignInPage";

Vue.use(VueRouter)

const routers = [
  {
    path: "/",
    name: 'app',
    component: App
  },

  {
    path: "/sign-in",
    name: 'sign-in',
    component: SignInPage
  }


]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routers
})

export default router
