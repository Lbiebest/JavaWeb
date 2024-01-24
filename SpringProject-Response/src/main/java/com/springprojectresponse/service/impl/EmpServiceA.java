package com.springprojectresponse.service.impl;

import com.springprojectresponse.dao.EmpDao;
import com.springprojectresponse.pojo.Emp;
import com.springprojectresponse.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component
@Service
public class EmpServiceA implements EmpService {

    private final EmpDao empDao;

    @Autowired
    public EmpServiceA(EmpDao empDao) {
        this.empDao = empDao;
    }


    @Override
    public List<Emp> listEmp() {
        List<Emp> parse = empDao.listEmp();
        // 对对象进行数据处理
        parse.forEach(emp -> {
            String gender = emp.getGender();
            if ("1".equals(gender)) {
                emp.setGender("男");
            } else if ("2".equals(gender)) {
                emp.setGender("女");
            }
        });
        return parse;
    }
}
