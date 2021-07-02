package com.myBlog.service;

import com.myBlog.bean.Blog;

import java.util.List;

/**
 * @Description
 * @Author Sunjh
 * @Date 2021/6/10 19:48
 */

public interface BlogService {
    List<Blog> selectAllBlogs();

    List<Blog> searchBlogByType(String searchBlog);

    Blog queryBlogById(int blogId);

    Blog updateBlogById(int blogId);

    int addNewBlog(Blog blog);
}
