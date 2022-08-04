import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/SignUpPage.vue'
import AboutView from '../views/LogInPage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'HomeView',
    component: HomeView
  },

  {
    path: '/about',
    name: 'about',
    component: AboutView
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
