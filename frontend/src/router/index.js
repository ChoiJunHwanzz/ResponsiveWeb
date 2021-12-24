import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

//공지사항
import GongziListPage from '@/views/gongzi/GongziListPage'
import GongziRegisterPage from '@/views/gongzi/GongziRegisterPage.vue'
import GongziReadPage from '@/views/gongzi/GongziReadPage.vue'
import GongziModifyPage from '@/views/gongzi/GongziModifyPage'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },

  
  // 공지사항
  {
    path: '/gongzi/create',
    name: 'GongziRegisterPage',
    components: {
      default: GongziRegisterPage,
    },
  },
  {
    path: '/gongzi/read',
    name: 'GongziReadPage',
    components: {
      default: GongziReadPage,
    },
  },
  {
    path: '/gongzi',
    name: 'GongziListPage',
    components: {
      default: GongziListPage,
    },
  },
  {
    path: '/gongzi/modify',
    name: 'GongziModifyPage',
    components: {
      default: GongziModifyPage,
    },
  },
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
