package com.myBlog.service;

import com.myBlog.bean.Blog;
import com.myBlog.dao.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Description
 * @Author Sunjh
 * @Date 2021/6/10 19:48
 */
@Service
public class BlogServiceImp implements BlogService{
    @Autowired
    BlogMapper blogMapper;
    @Override
    public List<Blog> selectAllBlogs() {
        return blogMapper.selectAllBlogs();
    }

    @Override
    public List<Blog> searchBlogByType(String searchBlog) {
        return blogMapper.searchBlogByType(searchBlog);
    }

    @Override
    public Blog queryBlogById(int blogId) {
        return blogMapper.queryBlogById(blogId);
    }

    @Override
    public Blog updateBlogById(int blogId) {
        return blogMapper.updateBlogById(blogId);
    }

    @Override
    public int addNewBlog(Blog blog) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat nowformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
        String nowDate = nowformat.format(timestamp);
        blog.setDate(nowDate);
        return  blogMapper.addNewBlog(blog);
    }
}
