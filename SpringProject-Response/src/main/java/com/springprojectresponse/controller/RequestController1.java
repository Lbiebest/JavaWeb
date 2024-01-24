package com.springprojectresponse.controller;

import com.springprojectresponse.pojo.User1;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController1 {

    // 保证请求参数名和形参对象属性名相同
    //    @RequestMapping("/simplePojo")
    //    public String simplePojo(User user) {
    //        System.out.println(user);
    //        return "OK";
    //    }

    // 复杂结构通过层次结构对应即可
    @RequestMapping("/simplePojo")
    public String simplePojo(User1 user1) {
        System.out.println(user1);
        return "OK";
    }
}
