package com.myBlog.controller;

import com.myBlog.utils.JwtUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description
 * @Author Sunjh
 * @Date 2021/6/14 20:57
 */
@Controller
@CrossOrigin
public class CheckTokenController {
    @RequestMapping("/checkToken")
    @ResponseBody
    public Boolean checkToken(HttpServletRequest request){
        String token = request.getHeader("token");
        //System.out.println(token);
        return JwtUtils.checkToken(token);
    }
}
