package com.myBlog.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @Description 文章的分类
 * @Author Sunjh
 * @Date 2021/6/15 12:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Type {
    private int id;
    private String typeName;
    private Timestamp date;
}
