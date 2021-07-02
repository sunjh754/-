package com.myBlog.dao;

import com.myBlog.bean.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description
 * @Author Sunjh
 * @Date 2021/6/10 22:05
 */
public interface BlogMapper {
    List<Blog> selectAllBlogs();

    List<Blog> searchBlogByType(String searchBlog);

    Blog queryBlogById(int blogId);

    Blog updateBlogById(int blogId);

    int addNewBlog(Blog blog);
}
