package com.springprojectmybatis;

import com.springprojectmybatis.mapper.EmpMapper;
import com.springprojectmybatis.mapper.UserMapper;
import com.springprojectmybatis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringProjectMybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void test() {
        List<User> list = userMapper.list();
        list.forEach(System.out::println);
    }

    @Test
    public void test1() {
        List<User> list = userMapper.manList();
        list.forEach(System.out::println);
    }

    @Test
    public void test2() {
        empMapper.delete(19);
    }

}
