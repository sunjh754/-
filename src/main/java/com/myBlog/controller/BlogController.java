package com.myBlog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myBlog.bean.Blog;
import com.myBlog.bean.Msg;
import com.myBlog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description 关于博客的增删改查
 * @Author Sunjh
 * @Date 2021/6/10 19:46
 */

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @RequestMapping(value = "/allBlogs",method = RequestMethod.GET)
    @ResponseBody
    public Msg getALLBlogs(@RequestParam(value = "pn",defaultValue = "1")Integer pn){
        PageHelper.startPage(pn,5);
        List<Blog> blogs=blogService.selectAllBlogs();
//        System.out.println(blogs.toString());
        PageInfo pageInfo = new PageInfo(blogs,5);
        return Msg.success().data("blog",blogs).data("pageInfo",pageInfo);
    }

    @ResponseBody
    @RequestMapping(value = "/searchBlogByType",method = RequestMethod.GET)
    public Msg searchBlogByType(@RequestParam("searchBlog")String searchBlog,
                                @RequestParam(value = "pn",defaultValue = "1")Integer pn){
        PageHelper.startPage(pn,5);
        List<Blog> blogs=blogService.searchBlogByType(searchBlog);
        PageInfo pageInfo = new PageInfo(blogs,5);
        return Msg.success().data("blog",blogs).data("pageInfo",pageInfo);
    }

    @ResponseBody
    @RequestMapping(value = "/queryBlogById",method = RequestMethod.GET)
    public Msg queryBlogById(@RequestParam("blogId")int blogId){
        Blog blog=blogService.queryBlogById(blogId);
        return Msg.success().data("blog",blog);
    }

    @ResponseBody
    @RequestMapping(value = "updateBlogById",method = RequestMethod.PUT)
    public Msg updateBlogById(@RequestParam("blogId")int blogId){
        Blog blog=blogService.updateBlogById(blogId);
        return Msg.success().data("blog",blog);
    }
    @ResponseBody
    @RequestMapping(value = "/addNewBlog",method = RequestMethod.POST)
    public Msg addNewBlog(@RequestBody Blog blog){
        int result = blogService.addNewBlog(blog);
        return Msg.success().data("result",result);
    }

}
