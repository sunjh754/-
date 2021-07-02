package com.myBlog.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author Sunjh
 * @Date 2021/6/7 15:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /*id*/
    private int id;
    /*用户名*/
    private String userName;
    /*密码*/
    private String passWord;
    private String token;
}
