package com.myBlog.service;

import com.myBlog.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author Sunjh
 * @Date 2021/6/7 19:56
 */
public interface LoginService {
   List<User> getAdminByLogin(@Param("userName") String userName,
                              @Param("passWord") String passWord);

}
