package com.springprojectresponse.controller;

import com.springprojectresponse.Result;
import com.springprojectresponse.pojo.Emp;
import com.springprojectresponse.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 解决 CORS 问题
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class EmpController1 {
    private final EmpService empService;
    // 运行时，IOC 容器会提供该类型的bean对象，并赋值给变量 - 依赖注入
    @Autowired
    public EmpController1(EmpService empService) {
        this.empService = empService;
    }

    @RequestMapping("/listEmp1")
    public Result<Object> list1() {
        //        调用 service 获取数据
        List<Emp> parse = empService.listEmp();
        return Result.success(parse);
    }
}
