<template>
	 <div  class="" style="opacity: .9;">
		  <div id="table-container" >
			  <table class="ui compact teal table" 
					 ref="multipleTable"
					 :data="articles"
					 @selection-change="handleSelectionChange" 
					 v-loading="loading"
					>
				  <thead>
					  <tr align="center" >
							<th>标题</th>
							<th>类别</th>
							<th>更新时间</th>
							<th>操作</th>
					  </tr>
				  </thead>
				  <tbody>
					  <tr align="center"  v-for="blog in list">
						  <td style="cursor: pointer">{{blog.title}}</td>
						  <td>{{blog.typeName}}</td>
						  <td>{{blog.date}}</td>
						  <td>
						  	<button>编辑</button>
							<button>删除</button>		
						  </td>
					  </tr>
				  </tbody>
				  <tfoot>
				  <tr>
				    <th colspan="5">
				      <div class="ui inverted divided stackable grid">
				        <div class="three wide column" align="center">
				          <a class="item" >上一页</a>
				        </div>
				  	
				        <div class="ten wide column" align="center">
				          <p>第 <span></span> 页，共 <span ></span> 页，有 <span ></span> 篇博客</p>
				        </div>
				        <div class="three wide column" align="center">
				          <a class="item" >下一页</a>
				        </div>
				      </div>
				    </th>
				  </tr>
				  </tfoot>
			  </table>
		  </div>
	    </div>
	  </div>
</template>

<script>
import axios from 'axios'
	export default {
		data() {
		    return {
				keywords: '',
				articles: [],
				loading: false,
		        checked: false,
				list: null,
				page: null,
		    };
		},
		mounted:function(){
			    this.blogList();
		    },
	    methods: {
			blogList:function(){
				    var that=this;
				    axios.get("http://localhost:8081/myBlog/blog/allBlogs")
				    .then(function(response){
						that.list=response.data.data.blog;
						that.page=response.data.data.pageInfo;
						console.log(response.data.data.blog)
				    })
			    },
			itemClick(blog){
        		this.$router.push({
					name:'editBlog',
					params:{id:blog},
					path: '/editBlog/${id}'})
      		},
			searchClick(){
				
			},
			handleSelectionChange(){
				
			},
			open() {
				this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning',
					center: true
				}).then(() => {
			    // _this.loading = true;
			    // var url = '';
			    // if (_this.state == -2) {
			    //   url = "";
			    // } else {
			    //   url = "";
			    // }
			    // putRequest(url, {aids: _this.dustbinData, state: state}).then(resp=> {
			    //   if (resp.status == 200) {
			    //     var data = resp.data;
			    //     _this.$message({type: data.status, message: data.msg});
			    //     if (data.status == 'success') {
			    //       window.bus.$emit('')//通过选项卡都重新加载数据
			    //     }
			    //   } else {
			    //     _this.$message({type: 'error', message: '删除失败!'});
			    //   }
			    //   _this.loading = false;
			    //   _this.dustbinData = []
			    // }, resp=> {
			    //   _this.loading = false;
			    //   _this.$message({type: 'error', message: '删除失败!'});
			    //   _this.dustbinData = []
			    // });
				}).catch(() => {
					this.$message({
					type: 'info',
					message: '已取消删除'
					});
				});
			},
			handleEdit() {
			   
			}
	    }
			
	}
	  
</script>

<style>
	@import url("https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css");
	.field>.mg_select {
		width: 7rem;
		height: 2.375rem;
		font-size: 0.875rem;
		border: none;
		border: 0.0625rem solid #DCDFE6;
		color:#606266;
		margin: 0 0.625rem;
		border-radius: 4px;
		outline:none
	}
	.mgTop input {
		font-size: 1rem;
		display: inline-block;
		width: 23.75rem;
		height: 2.375rem;
		border: 0 none;
		outline: 0;
		background: #f5f6f7;
		color: #222226;
		text-indent: 16px;
		border: 1px solid #e8e8ed;
		border-right: none;
		-webkit-box-sizing: border-box;
		box-sizing: border-box;
		border-radius: 4px 0 0 4px;
	}
	.mgTop .topSearch {
		display: inline-block;
	}
	.mgTop button {
		width: 5rem;
		height: 2.375rem;
		outline: 0;
		border: 0 none;
		background: url(../assets/search.png) no-repeat center left  gray;
		background-size: 40%;
		border-radius: 0 4px 4px 0;
		padding-left: 1.75rem;
		cursor: pointer;
		-webkit-box-sizing: border-box;
	}
</style>

