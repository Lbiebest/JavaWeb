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
