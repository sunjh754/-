import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '@/views/Login'
import Home from '../views/Home'
import axios from 'axios'
import Error from "../views/Error"
import Edit from "../views/Edit"
import BlogMagement from '../views/BlogMagement'
import Index from '../views/Index'
import DisplayBlog from "../views/DisplayBlog"
import Search from "../views/Search"
import TypeMagement from "../views/TypeMagement"

//import { from } from 'core-js/fn/array'

Vue.use(VueRouter)

const routes = [
  // 进入登录页面
  {
    path: '/login',
    name: 'Login',
    component: Login,
  },
  // 进入home页面
  {
    path: '/home',
    name: 'Home',
    component: () => import('../views/Home'),
    redirect: '/index',
    children: [
      {
        path: '/index',
        name: 'Index',
        component: ()=> import('../views/Index'),
      },
      {
        path: '/blogMagement',
        name: 'BlogMagement',
        component: ()=> import('../views/BlogMagement'),
        children:
          [{
            path: '/typeMagement',
            name: 'TypeMagement',
            component: ()=> import('../views/TypeMagement'),
          }, {
            path: '/editBlog',
            name: '编辑博客',
            component: Edit,
            hidden: true,
            meta: {
              keepAlive: false
            }
          }]
      },
      {
        path: '/edit',
        name: 'Edit',
        component: ()=> import('../views/Edit')
      },
      {
        path: '/DisplayBlog/:id/',
        name: 'DisplayBlog',
        component: ()=> import('../views/DisplayBlog')
      },
      {
        path: '/search',
        name: 'Search',
        component: ()=> import('../views/Search')
      },
      
    ]
  },
   {
    path: '/error',
    name: 'Error',
    component: ()=> import('../views/Error')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})


import ElementUI from 'element-ui';
// 进行页面跳转之前都需要认证token
router.beforeEach((to,from,next)=>{
  if(to.path.startsWith('/login'))
  {
    window.localStorage.removeItem('admin-login')
    next()
  }else{
    let user=JSON.parse(window.localStorage.getItem('admin-login'))
    console.log(window.localStorage.getItem('admin-login'))
    //console.log(user.data.user.token)
    if(!user){
      ElementUI.Message({
        message: '请先登录',
        type: 'error'
    });
      next({path:'/login'})
    }else{
      // 校验token合法
      //console.log(user.data.user.token)
      axios({
        url: 'http://localhost:8081/myBlog/checkToken',
        method: 'get',
        headers: {
          token: user.data.user.token
        }
      }).then((response) => {
        //console.log(response.data)
        if(!response.data){
          console.log('校验失败')
          next({path: '/error'}) 
        }
      })
      next()
    }
  }
})


export default router
