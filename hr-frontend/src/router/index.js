import Vue from 'vue'
import VueRouter from 'vue-router'
import LogInPage from "@/views/LogInPage";
import SignUpPage from "@/views/SignUpPage";
import ForgotPasswordPage from "@/views/ForgotPasswordPage";
import MainPage from "@/views/MainPage";

Vue.use(VueRouter)

const routes = [
  {
    path: "/",
    name: 'log-in',
    component: LogInPage
  },

  {
    path: "/sign-up",
    name: 'sign-up',
    component: SignUpPage
  },

  {
    path: "/new-password",
    name: 'new-password',
    component: ForgotPasswordPage
  },

  {
    path: "/main-page",
    name: 'main-page',
    component: MainPage
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
