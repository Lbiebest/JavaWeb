package com.springprojectresponse.controller;

import com.springprojectresponse.Result;
import com.springprojectresponse.pojo.Emp;
import com.springprojectresponse.utils.XmlParserUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:8080")
@RestController
public class EmpController {

    @RequestMapping("/listEmp")
    public Result list() {
        //        加载并解析xml文件
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> parse = XmlParserUtils.parse(file, Emp.class);

        // 对对象进行数据处理
        parse.stream().forEach(emp -> {
            String gender = emp.getGender();
            if ("1".equals(gender)) {
                emp.setGender("男");
            } else if ("2".equals(gender)) {
                emp.setGender("女");
            }
        });


        return Result.success(parse);
    }
}
