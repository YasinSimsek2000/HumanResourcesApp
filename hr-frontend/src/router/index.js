import Vue from 'vue'
import VueRouter from 'vue-router'
import LogInPage from "@/views/LogInPage";
import SignInPage from "@/views/SignInPage";

Vue.use(VueRouter)

const routes = [
  {
    path: "/",
    name: 'log-in',
    component: LogInPage
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
  routes
})

export default router
