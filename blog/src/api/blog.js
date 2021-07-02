import request from '@/utils/request'
export default{
    getListBlog(){
        return request({
            url:`/blog/allBlogs`,
            method: 'get'
        })
    }
}