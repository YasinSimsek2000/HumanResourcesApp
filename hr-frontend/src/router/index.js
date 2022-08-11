import Vue from 'vue'
import VueRouter from 'vue-router'
import LogInPage from "@/views/LogInPage";
import SignUpPage from "@/views/SignUpPage";
import ForgotPassword from "@/views/ForgotPasswordPage";

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
    component: SignUpPage
  },

  {
    path: "/new-password",
    name: 'new-password',
    component: ForgotPassword
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
