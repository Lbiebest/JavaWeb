# 请求响应

- [请求响应](#请求响应)
  - [工具](#工具)
  - [请求](#请求)
    - [简单参数](#简单参数)
    - [实体参数](#实体参数)
      - [简单实体参数](#简单实体参数)
      - [复杂实体参数](#复杂实体参数)
    - [数组集合参数](#数组集合参数)
      - [数组参数](#数组参数)
      - [集合参数](#集合参数)
    - [日期时间参数](#日期时间参数)
    - [json 参数](#json-参数)
    - [路径参数](#路径参数)
  - [响应](#响应)
    - [@ResponseBody](#responsebody)
    - [通过 Result 改造响应数据](#通过-result-改造响应数据)
  - [案例](#案例)

---

## 工具

[Postman](https://www.postman.com/)、
[apiPost](https://www.apipost.cn/)……

![图 10](https://s2.loli.net/2024/01/21/B3q1rQbCjZPXdkp.png)  

## 请求

### 简单参数

[简单参数详细说明][RequestController.java]

### 实体参数

#### [简单实体参数][RequestController1.java]

#### [复杂实体参数][RequestController1.java]

### 数组集合参数

#### [数组参数][RequestController.java]

#### [集合参数][RequestController.java]

### [日期时间参数][RequestController.java]

### [json 参数][RequestController.java]

### [路径参数][RequestController.java]

## 响应

### [@ResponseBody][RequestController2.java]

![图 11](https://s2.loli.net/2024/01/23/TXNhabEzKf9SpBw.png)  

### 通过 Result 改造响应数据

[RequestController3.java][RequestController3.java]

[Result.java][Result.java]

## 案例

解析xml文件,后端构建服务器，前端请求并展示
```xml
<?xml version="1.0" encoding="UTF-8"?>
<employees>
    <emp>
        <name>John Doe</name>
        <age>30</age>
        <image>https://api-storage.4ce.cn/v1/5910ce7790e91da5ca5a2b0171ada42c.jpg</image>
        <gender>1</gender>
        <job>软件工程师</job>
    </emp>
    <emp>
        <name>Jane Doe</name>
        <age>25</age>
        <image>https://api-storage.4ce.cn/v1/c241c1ed069ef6f9797e6d4042870d62.jpg</image>
        <gender>2</gender>
        <job>数据分析师</job>
    </emp>
    <emp>
        <name>Alice Smith</name>
        <age>28</age>
        <image>https://api-storage.4ce.cn/v1/a999c859fdda00566f1d5105e08638f1.jpg</image>
        <gender>2</gender>
        <job>产品经理</job>
    </emp>
    <emp>
        <name>Bob Johnson</name>
        <age>35</age>
        <image>https://api-storage.4ce.cn/v1/9c41896fb91284e29b807af35ff91cf3.jpg</image>
        <gender>1</gender>
        <job>市场营销</job>
    </emp>
    <emp>
        <name>Eva Williams</name>
        <age>27</age>
        <image>https://api-storage.4ce.cn/v1/7e67a7d5a689c35fc244b860771fbe54.jpg</image>
        <gender>2</gender>
        <job>软件开发</job>
    </emp>
</employees> 
```

![图 12](https://s2.loli.net/2024/01/23/ThuUexrdgQDBRkJ.png)  


[RequestController.java]:../SpringProject-Response/src/main/java/com/springprojectresponse/controller/RequestController.java
[RequestController1.java]:../SpringProject-Response/src/main/java/com/springprojectresponse/controller/RequestController1.java
[RequestController2.java]:../SpringProject-Response/src/main/java/com/springprojectresponse/controller/RequestController2.java
[RequestController3.java]:../SpringProject-Response/src/main/java/com/springprojectresponse/controller/RequestController3.java
[Result.java]:../SpringProject-Response/src/main/java/com/springprojectresponse/Result.java


