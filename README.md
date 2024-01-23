# Java Web

- [Java Web](#java-web)
  - [Maven](#maven)
  - [Springboot](#springboot)
  - [HTTP](#http)
    - [HTTP 请求协议](#http-请求协议)
    - [HTTP 响应格式](#http-响应格式)
    - [HTTP 协议解析](#http-协议解析)
  - [Web 服务器](#web-服务器)
    - [Tomcat](#tomcat)
  - [请求响应](#请求响应)

---

## Maven

- 环境搭建
- pom.xml 配置
- 相关命令

## Springboot

- 构建一个入门程序

```java
package com.example.springproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 应用程序的入口点，负责启动整个应用。
 */
@SpringBootApplication
public class SpringProjectApplication {

    /**
     * 应用程序的主方法，用于启动 Spring Boot 应用。
     *
     * @param args 命令行参数，可以在启动应用时传递
     */
    public static void main(String[] args) {
        // 使用 SpringApplication 类的静态方法 run 来启动 Spring Boot 应用
        SpringApplication.run(SpringProjectApplication.class, args);
    }

}
```

```java
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
```

## HTTP

### HTTP 请求协议

1. GET 请求

   请求参数在请求行中，没有请求体，请求大小有限制

2. POST 请求

   请求参数在请求体中，请求大小没有限制

### HTTP 响应格式

> 响应行： 协议、状态码、描述
> 响应头：
> 响应体： 响应数据

### HTTP 协议解析

通过 Web 服务器解析

## Web 服务器

### Tomcat

> `DispatcherServlet`
> `HttpsServletRequest`: 获取请求数据
> `HttpsServletResponse`: 获取响应数据

## [请求响应][请求响应]

---

[请求响应]:Note/requestResponse.md
