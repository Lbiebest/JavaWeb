package com.springprojectresponse.controller;

import com.springprojectresponse.Result;
import com.springprojectresponse.pojo.Emp;
import com.springprojectresponse.service.EmpService;
import com.springprojectresponse.service.impl.EmpServiceA;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 解决 CORS 问题
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class EmpController1 {
    private EmpService empService = new EmpServiceA();

    @RequestMapping("/listEmp1")
    public Result list1() {
        //        调用 service 获取数据
        List<Emp> parse = empService.listEmp();
        return Result.success(parse);
    }
}
