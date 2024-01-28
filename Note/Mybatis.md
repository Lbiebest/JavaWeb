# [Mybits][Mybits]

- [Mybits](#mybits)
  - [Mybits 入门](#mybits-入门)
    - [Lombok](#lombok)
  - [Mybits 增删改查](#mybits-增删改查)
  - [Mybits 动态 SQL](#mybits-动态-sql)

---

## Mybits 入门

- 导入依赖

  ```xml
  <dependency>
   <groupId>org.mybatis.spring.boot</groupId>
   <artifactId>mybatis-spring-boot-starter</artifactId>
   <version>3.0.3</version>
  </dependency>

  <dependency>
   <groupId>com.mysql</groupId>
   <artifactId>mysql-connector-j</artifactId>
   <scope>runtime</scope>
  </dependency>
  ```

- 配置sql

  ```properties
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
  spring.datasource.url=jdbc:mysql://localhost:3306/mybatis?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai
  spring.datasource.username=root
  spring.datasource.password=010525
  ```

- 构建实体类

  ```text
  构建与数据库结构相同的表
  ```

- 定义sql操作接口

  ```text
  通过 @Mapper 注解实现对数据库操作
  ```

### Lombok

| 注解                | 作用                       |
|---------------------|----------------------------|
| @Getter / @Setter   | 提供 get / set 方法        |
| @ToString           | 提供 toString 方法         |
| @EquelasAndHashCode | 重写 equel 和 hashcode方法 |
| @Data               | 综合生成以上方法           |
| @NoArgsConstructor  | 提供无参构造器             |
| @AllArgsConstructor | 提供有参构造器             |

## Mybits 增删改查

## Mybits 动态 SQL

[Mybits]:https://mybatis.org/mybatis-3/
