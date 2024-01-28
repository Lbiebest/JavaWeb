package com.springprojectmybatis.mapper;

import com.springprojectmybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//告诉 Mybatis 框架实现此接口的代理对象，可以通过接口调用来实现 SQL 语句，并将其注册为 Spring 的Bean
@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> list();

    @Select("select * from user where gender = 1")
    List<User> manList();
}
