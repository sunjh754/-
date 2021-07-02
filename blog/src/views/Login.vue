<template>
	<el-container>
		<div class="headerTop">
		    <!-- 包含导航搜索的区域 -->
		    <section class="headerTopBox">
		        <!-- 导航 -->
		        <nav class="navBox">
		            <a href="/">
		                <i>
		                    <img src="../assets/logo3.jpg"  alt="个人博客"/>
		                </i>
		                首页</a>
		            <a href="#">博客</a>
		            <a href="#">专区</a>
		            <a href="#">技术分享</a>
		            <a href="#">Blog留言</a>
		            <a href="#">关于我</a>
		        </nav>
		    </section>
		</div>
		<el-main class="bg">
		<el-form :rules="rules" ref="loginForm" :model="loginForm" class="loginContainer" label-width="80px">
			<h1 class="loginTitle">LOGIN</h1>
			<el-form-item label="用户名" prop="inputName">
				<el-input type="text" auto-complete="off" v-model="loginForm.inputName" placeholder="请输入用户名"></el-input>
			</el-form-item>
			<el-form-item label="密码" prop="inputPassWord">
				<el-input type="password" auto-complete="off" v-model="loginForm.inputPassWord" placeholder="请输入密码"></el-input>
			</el-form-item>
			<el-checkbox v-model="checked" class="loginRemember">记住密码</el-checkbox>
			<el-button type="primary" style="width: 80%; margin-top: 10px;margin-left: 50px;" @click="submitLogin" :loading="logining">登录</el-button>
		</el-form>
		</el-main>
	<el-footer>
				<ul class="footer-column-a">
				    <li>
				        <img src="../assets/tel.png" alt="">
				        888-888-888
				    </li>
				    <li>
				        <img src="../assets/email.png" alt="">
				        8888888@gmail.com
				    </li>
				    <li>
				        <img src="../assets/LogoGithub.png" alt="">
				        https://github.com/8888888
				    </li>
				</ul>
				<ul class="footer-column-b">
				    <li>
				        <img src="../assets/badge.png" alt="">
				        公安备案号XXXXXXXXX
				    </li>
				    <li>
				        <a href="https://beian.miit.gov.cn/#/Integrated/index">ICP/IP地址/域名信息备案管理</a>
				    </li>
				    <li>
				        <a href="">互联网违法和不良信息举报中心</a>
				    </li>
				    <li>
				        <a href="http://www.cyberpolice.cn/wfjb/" target="_blank">网络110报警服务</a>
				    </li>
				    <li>
				        <a href="https://www.12377.cn/" target="_blank">中国互联网举报中心</a>
				    </li>
				    <li>
				        <a href="#" target="_blank">Chrome商店下载</a>
				    </li>
				    <li>
				        <a href="https://blog.csdn.net/blogdevteam/article/details/90369522" target="_blank">版权申述</a>
				    </li>
				</ul>
			</el-footer>
		</el-container>
</template>

<script>
	import qs from 'qs'
	import JSON from 'JSON'
	export default{
		name:"Login",
		data() {
			return{		
				//记录登录状态
				logining: false,
				loginForm: {
					inputName: '',
					inputPassWord: ''
				},
				checked: false,                        //设置是否记住密码初始状态
				rules:{
					inputName:[{required:true,message:'请输入用户名',trigger:'blur'}],
					inputPassWord:[{required:true,message:'请输入密码',trigger:'blur'}]
				},
				responseResult: []
			}	
		},
		methods:{
			submitLogin(){
				 var _this = this;
        		this.loading = true;
				//refs调用已注册过的loginForm
				this.$refs.loginForm.validate((valid) => {
					var fm = this;
				    if (valid) {
				        this.$axios
						.post('myBlog/admin/doLogin', 
						qs.stringify({
							inputName: this.loginForm.inputName,
							inputPassWord: this.loginForm.inputPassWord
						}))
						
						.then(resp=> {
							
							 _this.loading = false;
							 if (resp.data.code== 200) {
								 //成功
								localStorage.setItem('admin-login',JSON.stringify(resp.data))
								console.log(localStorage.getItem('admin-login'))
								let user=JSON.parse(window.localStorage.getItem('admin-login'))
    							//console.log(user)
								//console.log(user.data.user.token)
              					_this.$router.replace({path: '/Home'});
           					 }else{
           					 //失败
            					_this.$alert('登录失败!', '失败!');
          					}
        				}, resp=> {
          					_this.loading = false;
          					_this.$alert('用户名或密码错误!', '失败!');
						});
					}
				})
			}
		}
	}
</script>

<style>
	/* 头部样式 */
	.headerBox {
	    height: 48px;
	    min-width: 1280px;
	    line-height: 48px;
	    margin: 0 auto;
	}
	.headerBox .headerTop {
	    padding: 0 24px;
	    margin: 0 auto;
	}
	.headerTopBox .navBox a{
		height: 48px;
		line-height: 48px;
	    padding: 15px 20px;
	}
	.headerTopBox .navBox a:hover {
	    background-color: rgba(0, 0, 0, .1);
	}
	.headerTopBox .navBox a img {
	    width: 32px;
	    height: 32px;
	}
	
	.loginContainer {
		border-radius: 15px;
		background-clip: padding-box;
		margin: 180px auto;
		width: 450px;
		padding: 15px 35px 15px 35px;
		min-height: 300px;
		/* width: 700px; */
		position: absolute;
		left: 50%;
		top: 50%;
		margin-left: -225px;
		margin-top: -150px;
		background-color: rgba(255,255,255,.65);
		border: 1px solid #eaeaea;
	}
	.loginTitle {
		margin: 0 auto;
		padding-bottom: 20px;
		text-align: center;
	}
	.loginRemember {
		float: right;
		margin: -5px 15px 0 0;
	}
	.bg {
		height: 642px;
		background: url(../assets/background1.jpg) no-repeat center center ;
		position: relative;
	}
	
	/* 底部样式 */
	.footer-column-a {
	    display: flex;
	    justify-content: center;
	    margin-top: 12px;
	    font-size: 14px;
	}
	.footer-column-a li {
	    margin: 0 8px;
	    color: #999aaa;
	}
	
	.footer-column-a img {
	    width: 16px;
	    height: 16px;
	}
	
	.footer-column-b {
	    margin-top: 6px;
	    display: flex;
	    justify-content: center;
	    flex-wrap: wrap;
	}
	.footer-column-b li {
	    font-size: 12px;
	    color: #999aaa;
	    margin: 0 6px;
	}
	.footer-column-b li img {
	    width: 14px;
	    height: 14px;
	}
	.footer-column-b li a {
	    color: #999aaa;
	}
</style>
