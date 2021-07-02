package com.myBlog.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Description
 * @Author Sunjh
 * @Date 2021/6/12 23:01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    private int id;
    private String title;
    private String date;
    private int type;
    private String typeName;
    private String mdContent;
    private String htmlContent;
}
