package com.springprojectresponse.dao.impl;

import com.springprojectresponse.dao.EmpDao;
import com.springprojectresponse.pojo.Emp;
import com.springprojectresponse.utils.XmlParserUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

//@Component
@Repository
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        //        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        //        通过 Objects.requireNonNull() 进行非空检查，避免空指针异常
        String file = Objects.requireNonNull(this.getClass().getClassLoader().getResource("emp.xml")).getFile();
        System.out.println(file);
        List<Emp> parse = XmlParserUtils.parse(file, Emp.class);
        return parse;
    }
}
