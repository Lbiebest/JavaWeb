package com.springprojectresponse.dao.impl;

import com.springprojectresponse.dao.EmpDao;
import com.springprojectresponse.pojo.Emp;
import com.springprojectresponse.utils.XmlParserUtils;

import java.util.List;

public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> parse = XmlParserUtils.parse(file, Emp.class);
        return parse;
    }
}
