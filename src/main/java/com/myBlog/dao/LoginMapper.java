package com.myBlog.dao;

import com.myBlog.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author Sunjh
 * @Date 2021/6/7 19:58
 */
public interface LoginMapper {
 List<User> getAdminByLogin(@Param("inputName") String inputName,
                            @Param("inputPassWord") String inputPassWord);
}
