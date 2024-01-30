package com.springprojectmybatis;

import com.springprojectmybatis.mapper.EmpMapper;
import com.springprojectmybatis.mapper.UserMapper;
import com.springprojectmybatis.pojo.Emp;
import com.springprojectmybatis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Test
    public void test3() {
        Emp emp = new Emp();
        emp.setUsername("Tom1");
        emp.setName("汤姆");
        emp.setImage(null);
        emp.setJob((short) 1);
        emp.setEntryTime(LocalDate.of(2000, 12, 12));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
        System.out.println(emp.getId());
    }

    @Test
    public void testUpdate() {
        Emp emp = new Emp();
        emp.setId(18);
        emp.setUsername("Tom11");
        emp.setName("汤姆一世");
        emp.setImage(null);
        emp.setJob((short) 2);
        emp.setUpdateTime(LocalDateTime.now());


        empMapper.update(emp);
    }

    @Test
    public void testSelect() {
        Emp emp = empMapper.getByID(2);
        System.out.println(emp);
    }

    @Test
    public void testSelect1() {
        List<Emp> select = empMapper.select(
                "张",
                (short) 1,
                LocalDate.of(2021, 3, 3),
                LocalDate.of(2023, 3, 3)
        );

        List<Emp> selected = empMapper.select(null, null, null, null);

        System.out.println(selected);
    }
}
