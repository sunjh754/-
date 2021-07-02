package com.myBlog.controller;

import com.myBlog.bean.Msg;
import com.myBlog.bean.User;
import com.myBlog.service.LoginService;
import com.myBlog.utils.CrowdConstant;
import com.myBlog.utils.CrowdUtil;
import com.myBlog.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;


/**
 * @Description
 * @Author Sunjh
 * @Date 2021/6/7 15:32
 */
@CrossOrigin
@Controller
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    LoginService loginService;
    @RequestMapping(value = "/doLogin")
    @ResponseBody
    public Msg Login(
            @RequestParam("inputName")String inputName,
            @RequestParam("inputPassWord")String inputPassWord
    ){
        //将传来的表单数据用md5加密
        String userPswdForm = CrowdUtil.md5(inputPassWord);
        List<User> user = loginService.getAdminByLogin(inputName,userPswdForm);
        User user1 = user.get(0);
        user1.setToken(JwtUtils.getJwtToken(user1.getUserName(),user1.getPassWord()));
        return Msg.success().data("user",user1);
    }
}