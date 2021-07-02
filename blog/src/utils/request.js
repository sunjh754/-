import axios from 'axios'
// 创建axios的实例

const service=axios.create({
    baseURL:'http://localhost:8081',
    timeout: 20000
})

export default service