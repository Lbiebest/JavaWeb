
# 构建一个入门程序

- [构建一个入门程序](#构建一个入门程序)
  - [Springboot的启动入口](#springboot的启动入口)
  - [Springboot的自定义控制器](#springboot的自定义控制器)

---
## Springboot的启动入口

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

## Springboot的自定义控制器

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
