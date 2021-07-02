package com.myBlog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myBlog.bean.Blog;
import com.myBlog.bean.Msg;
import com.myBlog.bean.Type;
import com.myBlog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description
 * @Author Sunjh
 * @Date 2021/6/15 12:42
 */
@Controller
@RequestMapping(value = "/type")
public class TypeController {
    @Autowired
    TypeService typeService;
    @RequestMapping(value = "/allTypes",method = RequestMethod.GET)
    @ResponseBody
    public Msg getALLBlogs(){
        List<Type> types=typeService.getAllTypes();
        return Msg.success().data("type",types);
    }
}
