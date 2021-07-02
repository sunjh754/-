<template>
    <div class="dispaly" v-loading="loading">
        <div>
            <div class="htmlContent" v-html="blog.htmlContent"></div>
        </div>
    </div>
</template>
<script>
	import axios from 'axios'
    
	export default {
        data() {
            id:''
            return {
                loading: false,
                blog:{}
            }
        },
		mounted:function() { 
            this.loading = true;
            var _this = this;
            console.log(this.$route.params.id)
            var blogId = this.$route.params.id;  
			axios.get("http://localhost:8081/myBlog/blog/queryBlogById?blogId="+blogId)
				    .then(function(response){
                        if (response.status == 200) {
                        _this.blog = response.data.data.blog;
                    }
                        _this.loading = false;
				    },response=> {
                        _this.loading = false;
                        _this.$message({type: 'error', message: '页面加载失败!'})
                    })
        },
    }
</script>
<style>
    .htmlContent{
		height: 100%;
		width:1000px;
		background: rgba(245,245,245,.7);
		position: relative;
		margin-left: 200px;
		margin-top: 100px;
    	padding: 1em;
    	border-radius: 1rem;
	}
</style>