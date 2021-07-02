package com.myBlog.service;

import com.myBlog.bean.Type;
import com.myBlog.dao.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author Sunjh
 * @Date 2021/6/16 13:51
 */
@Service
public class TypeServiceImp implements TypeService{
    @Autowired
    TypeMapper typeMapper;
    @Override
    public List<Type> getAllTypes() {
        return typeMapper.getAllTypes();
    }
}
