package com.springprojectresponse.controller;

import com.springprojectresponse.pojo.User1;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

//@Controller
//@ResponseBody
//组合注解
@RestController
public class RequestController {

    //    原始方式获取请求参数
    //    @RequestMapping("/simpleParam")
    //    public String simpleParam(HttpServletRequest request) {
    //        // 获取请求参数
    //        String name = request.getParameter("name");
    //        int age = Integer.parseInt(request.getParameter("age"));
    //
    //        System.out.println(name + " : " + age);
    //        return "OK";
    //    }

    //    Springboot 接收简单参数
    //    请求参数与方法形参变量名相同
    //    会自动进行类型转换
    //    @RequestMapping("/simpleParam")
    //    public String simpleParam(String name,Integer age) {
    //
    //        System.out.println(name + " : " + age);
    //        return "OK";
    //    }


    // 如果方法形参名称与请求参数名称不匹配，可以使用 @RequestParam 完成映射
    // name = "name" 是在指定请求参数的名称，而不是指定方法形参的名称
    // 通过 required 控制参数是否必须传递
    @RequestMapping("/simpleParam")
    public String simpleParam(@RequestParam(name = "name", required = true) String username, Integer age) {
        System.out.println(username + " : " + age);
        return "OK";
    }


    //    默认情况下 @RequestParam 会根据形参名称匹配请求参数
    //    @RequestMapping("/simpleParam")
    //    public String simpleParam(@RequestParam("name") String username, Integer age) {
    //     System.out.println(username + " : " + age);
    //        return "OK";
    //    }

    //    数组参数
    @RequestMapping("/arrayParam")
    public String simpleArrayParam(@RequestParam String[] hobby) {
        System.out.println(Arrays.toString(hobby));
        return "OK";
    }

    //    集合参数
    //    通过 @RequestParam 绑定参数关系
    @RequestMapping("/listParam")
    public String simpleListParam(@RequestParam List<String> hobby) {
        System.out.println(hobby);
        return "OK";
    }

    //    日期时间参数
    //    通过 @DateTimeFormat 指定传递的时间参数格式
    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateDateTime) {
        System.out.println(updateDateTime);
        return "OK";
    }

    //    json 参数
    //    通过 @RequestBody 指定传递 json 数据
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User1 user1) {
        System.out.println(user1);
        return "OK";
    }

    //    路径参数
    @RequestMapping("/path/{id}/{name}")
    public String pathParam(@PathVariable Integer id, @PathVariable String name) {
        System.out.println(id + " : " + name);
        return "OK";
    }
}
