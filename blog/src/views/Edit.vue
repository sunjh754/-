<template>
	<div class="article-bar" v-loading="loading">
		<div class="article-bar_link-box">
			<router-link to="/Home">
				 <el-page-header content="文章列表" style="color:#fff;font-color:#fff">
				</el-page-header>
			</router-link>
		</div>
		<div class="article-bar_input-box">
			<input v-model="blog.title" placeholder="请输入文章标题(0~20)" class="article-bar_title-bar">
			<el-select v-model="blog.tid" placeholder="请选择文章类型">
				<el-option
      				v-for="item in list"
      				:key="item.id"
					:label="item.typeName"
      				:value="item.id">
    			</el-option>
			</el-select>
			<el-tag type="success" @click="typeClick" style="cursor: pointer;margin-left:40px">新增分类</el-tag>
			<el-button type="primary"  style="width:200px ;margin-left:100px" round 
			@click="saveBlog">发布文章</el-button>
		</div>
		
		<mavon-editor v-model="value" ref="md"
     	style="min-height: 600px;opacity: 0.9;" />
	</div>
</template>
 
<script>
// 导入组件 及 组件样式
	import { mavonEditor } from 'mavon-editor'
	import 'mavon-editor/dist/css/index.css'
  	import axios from 'axios'
	import {isNotNullORBlank} from '../utils/utils'
	import JSON from 'JSON'
	import qs from 'qs'
	
	export default {
	  components: {
		  mavonEditor
	  },
	  data () {
		    return {
			// 选择器中的数据
			  list: [],
			  blog:{
				  id: '-1',
				  title:'',
				  tid:'',
				  mdContent:'',
				  htmlContent:'',
				},
		      articleForm:{
			      type: ''
		      },
		      submit: false,
			  loading: false,
			  inputVisible: false,
			  inputValue: '',
			  value:''
		    }
	  	},
	  	mounted:function(){
			this.typeList();
		},
    
	  methods: {
		  //页面加载时，发送查找全部分类的请求
      	typeList:function(){
        		var that=this;
        		axios.get("http://localhost:8081/myBlog/type/allTypes")
        		.then(function(response){
					console.log(response.data.data.type)
					that.list=response.data.data.type;
					console.log(that.list)
				})
      	},
		saveBlog(){
			var _this = this;
			if (!(isNotNullORBlank(_this.blog.title, _this.$refs.md.d_value, _this.blog.tid))) {
          			this.$message({type: 'error', message: '数据不能为空!'});
          			return;
        		}
			_this.loading = true;
			let data={id: _this.blog.id,
          		title: _this.blog.title,
				type: _this.blog.tid,
          		mdContent: _this.$refs.md.d_value,
          		htmlContent: _this.$refs.md.d_render, }
			axios.post("http://localhost:8081/myBlog/blog/addNewBlog",data)
			.then(resp=> {
          		_this.loading = false;
				console.log(resp.data.code,resp.data.msg)
				if (resp.data.code == 200 && resp.data.msg == '处理成功！') {
					_this.$message({type: 'success', message: '发布成功!'});
					_this.$router.push({
						path: '/home',
            			name: 'Home',
					})
				}
			},resp=> {
          				_this.loading = false;
         				_this.$message({type: 'error', message:'博客发布失败!'});
				},
			)
		},
		typeClick(){
					this.$router.push({
						path: '/typeMagement',
            			name: 'TypeMagement',
					})
				},
	  },
	}
</script>

<style>
	.article-bar {
		height: 100%;
		
	}
  /*修改页头的字体颜色*/
  .article-bar_link-box .el-page-header__content {
    color: #fff;
  }
	.article-bar_link-box {
		//margin: 12px auto;
		padding: 0 8px;
		float: left;
   		opacity: 0.9;
		
	}
	
	.article-bar_input-box input {
		margin-left: 10px;
		border-radius: 18px;
		padding: 8px;
		padding-right: 88px;
		font-size: 18px;
		line-height: 26px;
		background-color: #fff;
    	opacity: 0.9;
		margin-top: 2px;
		margin-bottom:20px;
	}
	.el-button.is-round {
    	opacity: 0.9;
	}

	
	.input-new-type {
    margin-left: 20px;
    vertical-align: bottom;
  	}
	.el-select .el-input .el-select__caret {
      margin-top: -8px;
    }

  
</style>