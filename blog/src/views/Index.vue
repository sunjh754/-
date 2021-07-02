<template>
    <div>
    <!--所有的博文信息-->
	<div class="blogdisplay" v-for="blog in list">
	    <!--单个博文信息>
		<div class="eachblog">
			<!--博文的标题 点击浏览-->
			<div style="height:30px;margin-top: 5px;" >
			    文章标题：
				<a style="font-size: 25px; color: #1E90FF;font-family:Trebuchet MS;cursor: pointer" 
				@click="itemClick(blog.id)">
				{{blog.title}}</a>
			</div>
			<div style="height:200px;margin-top: 5px;margin-bottom:5px">
				<p>{{blog.mdContent | blogText}}</p>
			</div>
			<div class="item" style="height:40px;margin-top: 5px;margin-left:20px">
				<i class="el-icon-date" style="margin-right:10px"></i><span>{{blog.date}}</span>	
				<el-tag type="success" @click="typeClick" style="cursor: pointer;margin-left:650px">{{blog.typeName}}</el-tag>
			</div>
		</div>
		<tfoot>
			<div>
				<div class="">首页</div>

			</div>
		</tfoot>
	</div>
	
    </div>
</template>
<script>
	import blog from '@/api/blog'
	import axios from 'axios'

	export default {
			filters: {
   				blogText(value){
      				if(!value) return ''
     				 if(value.length > 800){
     					 return value.slice(0,800) + '......'
      				}
					return value
  				}
			},
		
	        data: function() {
    	        return {
      	            list: null,
					page:null,
    	        };
	        },
		    mounted:function(){
			    this.blogList();
		    },
		    methods:{
			    blogList:function(){
				    var that=this;
				    axios.get("http://localhost:8081/myBlog/blog/allBlogs")
				    .then(function(response){
						that.list=response.data.data.blog;
						that.page=response.data.data.pageInfo;
						console.log(page)
				    })
			    },
				
				itemClick(blog){
        			this.$router.push({
						name:'DisplayBlog',
						params:{id:blog},
						path: '/DisplayBlog/${id}'})
      			},
				typeClick(){
					this.$router.push({
						path: '/typeMagement',
            			name: 'TypeMagement',
					})
				},
      		}
        }
</script>
<style>
    .blogdisplay{
		height: 300px;
		width:1000px;
		background: rgba(245,245,245,.7);
		position: relative;
		margin-left: 200px;
		margin-top: 150px;
    	padding: 1em;
    	border-radius: 1rem;
	}
	.blogdisplay .a{
		text-align:center;
	}

	.blogdisplay .type{
		
	}
</style>