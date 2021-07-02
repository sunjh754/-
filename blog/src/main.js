import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from 'axios'


Vue.use(ElementUI);

// 设置反向代理，前端请求默认发送到 http://localhost:8081/api
var ax = require('axios')
ax.defaults.baseURL = 'http://localhost:8081'

//跨域访问前端能够带上 cookie
ax.defaults.withCredentials = true

//全局注册，之后可在其他组件中通过this.$axios 发送数据
Vue.prototype.$axios = axios
Vue.config.productionTip = false



new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
