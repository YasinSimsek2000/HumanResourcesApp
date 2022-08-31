import Vue from 'vue'
import VueRouter from 'vue-router'
import LogInPage from "@/views/LogInPage";
import SignUpPage from "@/views/SignUpPage";
import ForgotPasswordPage from "@/views/ForgotPasswordPage";
import HomePage from "@/views/HomePage";
import DepartmentPage from "@/views/DepartmentPage"
import EmployeePage from "@/views/EmployeePage";

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
    path: "/home",
    name: 'home',
    component: HomePage
  },

  {
    path: "/departments",
    name: 'departments',
    component: DepartmentPage
  },

  {
    path: "/employees",
    name: 'employees',
    component: EmployeePage
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
