package com.example.springproject.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 请求处理类
@RestController
public class HelloController {
    // 将 /hello 映射到下面的方法，当浏览器访问时，将调用这个方法

    // @RequestMapping 注解用于映射 HTTP 请求路径，这里表示当访问 /hello 路径时，
    // 将由下面的方法处理请求，并返回相应的响应。
    @RequestMapping("/hello")
    public String Hello() {
        // 控制台输出 "Hello World"，用于在应用程序的日志中显示一些信息。
        System.out.println("Hello World");

        // 返回字符串 "Hello World"，这将作为 HTTP 响应的主体内容返回给客户端。
        return "Hello World";
    }
}
