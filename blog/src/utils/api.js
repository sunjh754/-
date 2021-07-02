import axios from 'axios'
import {Message} from "element-ui";
import route from '../router';

//响应拦截器
/*上面已经导入了axios的对象了，这个对象里面有个响应的拦截器axios.interceptors.response.use(),use里面的data是服务端响应给你的数据，
该拦截器有两个回调函数，一个是success，一个是error,和jQuery里面的ajax一样请求数据的时候也有两个回调函数，一个success，一个error,可以简单的理解为
http的响应码是200的，它会进入到success方法中来，400以上的会进入到error来，
*/
axios.interceptors.response.use(success => {
	if(success.status && success.status == 200 && success.data.status == 500){
		Message.error({message:success.data.message})
		return;
	}
	return success.data
},error=> {
	if (error.response.status==504 || error.response.status==404){
		Message.error({message:'服务器被吃了'})
	}else if (error.response.status == 403) {
		Message.error({message:'权限不足，请联系管理员！'})
	}else if (error.response.status==401) {
		Message.error({message:'尚未登录，请登录'})
		route.replace('/')
	}else {
		if (error.response.data.message){
			Message.error({message:error.response.data.message})
		} else {
			Message.error({message:'未知错误'})
		}
	}
	return;
});

