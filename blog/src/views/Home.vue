<template>
	<el-container  class="home_container">
		<el-header class="header">
				<a>
				    <img src="../assets/logo2.png" style="width: 60px; height: 60px; margin: 0 15px;"/>
				</a>
				<h2 style="color: beige;">Joey Blog</h2>
				
				<ul class="nav">

					<li class="hover">
						<i class="el-icon-s-home" style="margin-right:7px"></i>
						<router-link to="/index">首页</router-link>
					</li>
					<li>
						<i class="el-icon-s-operation" style="margin-right:7px"></i>
						<router-link to="/BlogMagement">博客管理</router-link>
					</li>
					<li>
						<i class="el-icon-edit-outline" style="margin-right:7px"></i>
						<router-link to="/Edit">创作中心</router-link>
					</li>
				</ul>
				<div class="searchBox">
					<div class="box">
						<div class="search">
							<input  v-model="searchInput" autocomplete="off" placeholder="请输入分类名" />
							<button @click="SearchClick"></button>
						</div>
					</div>
				</div>
				<ul class="nav">
					<li>消息</li>
					<li>
						<router-link to="/Text2">技术问答</router-link>
					</li>
					<el-dropdown trigger="click" @command="handleCommand">
					    <span class="el-dropdown-link">
					      个人中心<i class="el-icon-arrow-down el-icon--right"></i>
					    </span>
					    <template #dropdown>
							<el-dropdown-menu>
							  <el-dropdown-item  command="a" icon="el-icon-circle-plus-outline" >退出</el-dropdown-item>
							</el-dropdown-menu>
					    </template>
					</el-dropdown>
				</ul>
		</el-header>

		<el-main class="main">
			<router-view></router-view>
		</el-main>
		
	</el-container>	
</template>

<script>
	import blog from '@/api/blog'
	import axios from 'axios'
	import qs from 'qs'
	import Router from '@/views/Search'

	export default {
	
		methods:{
			data(){
				 return {
      				searchInput:''
    			}
			},
			SearchClick:function(){
				var _this=this
				var searchBlog=this.searchInput
				axios.get("http://localhost:8081/myBlog/blog/searchBlogByType",{params:{searchBlog}})
				.then(function(response){
                        if (response.status == 200) {
							_this.$router.push({
								name:'Search',
								path: '/search'
							})
						}if(response.status===400){
							alert("错误")
						}
				})
			},
			
			
			handleCommand(command) {
        		this.$confirm('是否退出登录', '提示', {
         		confirmButtonText: '确定',
          		cancelButtonText: '取消',
          		type: 'warning'
        	}).then(() => {
					// 清空token
					window.sessionStorage.clear()
					// 跳转到登陆页面
					this.$router.push('/login')
          			this.$message({
            		type: 'success',
            		message: '您已成功退出登录!'
          			});
        		}).catch(() => {
          			this.$message({
            		type: 'info',
            		message: '已取消退出登录'
          			});          
        		});
      		}
    	}
	}
</script>

<style>
	
	.home_container {
		background: url(../assets/background1.png) no-repeat;
	  height: 100%;
	  position: absolute;
	  top: 0px;
	  left: 0px;
	  width: 100%;
	  overflow:auto;
	}
	.header {
		width: 100%;
   		opacity: 0.9;
    	font-size: 15px;
		background-color: rgba(0,0,0,1);
	  	display: flex;
	  	align-items: center;
	}
	.header li{
		background: rgba(255,255,255,.15);
    	color: #fff!important;
		line-height: 60px;
		float: left;
		margin-left: 25px;
		padding: 0 15px;
		font-size: 16px;
		cursor: pointer;
		border-radius:10px 10px 10px 10px 
	}
	.header li>a {
		background: 0 0;
    	color: rgba(255,255,255,.9);
	}
	.header .el-dropdown{
		height: 60px;
		line-height: 60px;
		float: left;
		margin-left: 25px;
		padding: 0 15px;
		font-size: 16px;
		cursor: pointer;
		
	}
	.header .el-dropdown .el-dropdown-link {
		color: #fff;
	}
	
	.header li:hover{
		background-color: #604E6E;
	}
	.home_userinfo {
	  color: #fff;
	  cursor: pointer;
	}
	.navMain .nav .drop {
		width: 120px;
		height:auto;
	}
	.searchBox {
		flex: 1;
		padding: 0 25px;
	}
	.box {
		width: 100%;
		max-width: 720px;
		height: 45px;
		line-height: 45px;
		margin-top: calc((60px - 48px)/ 2);
		margin-left: auto;
		margin-right: auto;
		position: relative;
	}
	.search{
		width: 100%;
		height: 100%;
		-webkit-box-sizing: border-box;
		box-sizing: border-box;
		font-size: 0;
	}
	.search input {
		font-size: 16px;
		display: inline-block;
		width: calc(100% - 40px);
		height: 100%;
		line-height: inherit;
		border: 0 none;
		outline: 0;
		background: #f5f6f7;
		color: #222226;
		vertical-align: top;
		text-indent: 16px;
		border: 1px solid #e8e8ed;
		-webkit-box-sizing: border-box;
		box-sizing: border-box;
		border-radius: 4px 0 0 4px;
	}
	.search button {
		width: 40px;
		height: 100%;
		outline: 0;
		border: 0 none;
		background: url(../assets/search.png) no-repeat center center #604E6E;
		background-size: 70%;
		border-radius: 0 4px 4px 0;
		font-size: 0;
		cursor: pointer;
		-webkit-box-sizing: border-box;
	}



</style>
