# [Mybits][Mybits]

- [Mybits](#mybits)
  - [Mybits 入门](#mybits-入门)
    - [Lombok](#lombok)
  - [Mybits 增删改查](#mybits-增删改查)
    - [Delete](#delete)
    - [Insert](#insert)
    - [Update](#update)
    - [Select](#select)
    - [XML 映射](#xml-映射)
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

### Delete

```java
// 接口方法
@Delete("delete from emp where id = #{id}")
void delete(Integer id);
```

```java
// 采用预编译SQL
// 提升性能
// 防止SQL注入
==>  Preparing: delete from emp where id = ?
==> Parameters: 19(Integer)
<==    Updates: 0
```

### Insert

```java
# 通过封装实体类来传递数据
# @Options 获取指定生成的字段
@Options(keyProperty = "id",useGeneratedKeys = true)
@Insert("insert into emp(username, name, image, job, entry_time, create_time, update_time)" +
        "  values (#{username},#{name},#{image},#{job},#{entryTime},#{createTime},#{updateTime});")
void insert(Emp emp);
```

```java
==>  Preparing: insert into emp(username, name, image, job, entry_time, create_time, update_time) values (?,?,?,?,?,?,?);
==> Parameters: Tom1(String), 汤姆(String), null, 1(Short), 2000-12-12(LocalDate), 2024-01-29T13:32:30.417900700(LocalDateTime), 2024-01-29T13:32:30.417900700(LocalDateTime)
<==    Updates: 1
Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@66e827a8]
24
```

### Update

```java
@Update("UPDATE emp SET username = #{username}, name = #{name}, image = #{image}, job = #{job}, " +
            "update_time = #{updateTime} WHERE id = #{id}")
void update(Emp emp);
```

```java
==>  Preparing: UPDATE emp SET username = ?, name = ?, image = ?, job = ?, update_time = ? WHERE id = ?
==> Parameters: Tom11(String), 汤姆一世(String), null, 2(Short), 2024-01-29T14:39:59.776108600(LocalDateTime), 18(Integer)
<==    Updates: 1
```

### Select

```java
// 查询功能
// 时间值返回为 null
// 解决方案：
// 1. 通过别名实现
// 2. @Results @Result 手动封装
//    @Results({
//            @Result(column = "entry_time", property = "entryTime"),
//            @Result(column = "create_time", property = "createTime"),
//            @Result(column = "update_time", property = "updateTime")
//    })
// 3. mybatis 驼峰命名自动映射开关
@Select("select id, username, password, name, gender, image, job, entry_time, create_time, update_time" + " from emp where id = #{id}")
Emp getByID(Integer id);
```

```properties
# Camel case naming covention
mybatis.configuration.map-underscore-to-camel-case=true
```

问题复现：

```java
==>  Preparing: select * from emp where id = ?
==> Parameters: 2(Integer)
<==    Columns: id, username, password, name, gender, image, job, entry_time, create_time, update_time
<==        Row: 2, user2, 32693756, 李四, 2, image2.jpg, null, 2022-02-02, 2024-01-28 17:54:03, 2024-01-28 18:09:35
<==      Total: 1
Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@6d293993]
Emp(id=2, username=user2, password=32693756, name=李四, gender=2, image=image2.jpg, job=null, entryTime=null, createTime=null, updateTime=null)
```

解决结果：

```java
==>  Preparing: select id, username, password, name, gender, image, job, entry_time, create_time, update_time from emp where id = ?
==> Parameters: 2(Integer)
<==    Columns: id, username, password, name, gender, image, job, entry_time, create_time, update_time
<==        Row: 2, user2, 32693756, 李四, 2, image2.jpg, null, 2022-02-02, 2024-01-28 17:54:03, 2024-01-28 18:09:35
<==      Total: 1
Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@38a4e2b0]
Emp(id=2, username=user2, password=32693756, name=李四, gender=2, image=image2.jpg, job=null, entryTime=2022-02-02, createTime=2024-01-28T17:54:03, updateTime=2024-01-28T18:09:35)
```

条件查询

```java
// name 字段需要实现模糊搜索
// 1. 字符串中使用 ${} 替换 #{}, 会产生安全问题
// 2. 通过 sql 中的 concat() 实现
@Select("SELECT * FROM emp WHERE name LIKE CONCAT('%', #{name}, '%') AND gender = #{gender} " +
          "AND entry_time BETWEEN #{startTime} AND #{endTime} ORDER BY update_time DESC")
List<Emp> select(String name, Short gender, LocalDate startTime,LocalDate endTime);
```

```java
==>  Preparing: SELECT * FROM emp WHERE name LIKE CONCAT('%', ?, '%') AND gender = ? AND entry_time BETWEEN ? AND ? ORDER BY update_time DESC
==> Parameters: 张(String), 1(Short), 2021-03-03(LocalDate), 2023-03-03(LocalDate)
<==    Columns: id, username, password, name, gender, image, job, entry_time, create_time, update_time
<==        Row: 1, user1, 75922139, 张三, 1, image1.jpg, null, 2022-01-01, 2024-01-28 17:54:03, 2024-01-28 18:09:35
<==      Total: 1
Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@42297bdf]
[Emp(id=1, username=user1, password=75922139, name=张三, gender=1, image=image1.jpg, job=null, entryTime=2022-01-01, createTime=2024-01-28T17:54:03, updateTime=2024-01-28T18:09:35)]
```

### XML 映射

通过 xml 文件创建映射实现 sql 执行

```xml
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.springprojectmybatis.mapper.EmpMapper">
    <select id="select" resultType="com.springprojectmybatis.pojo.Emp">
        SELECT * FROM emp WHERE name LIKE CONCAT('%', #{name}, '%') AND gender = #{gender} AND entry_time BETWEEN
        #{startTime} AND #{endTime} ORDER BY update_time DESC
    </select>
</mapper>
```

## Mybits 动态 SQL

通过动态标签实现 SQL 的 动态查询 

```xml
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.springprojectmybatis.mapper.EmpMapper">
    <select id="select" resultType="com.springprojectmybatis.pojo.Emp">
        SELECT *
        FROM emp
        <where>
            <if test="name != null">
                name LIKE CONCAT('%',
                #{name},
                '%'
                )
            </if>
            <if test="gender != null">
                AND gender = #{gender}
            </if>
            <if test="startTime != null and endTime != null">
                AND entry_time BETWEEN
                #{startTime}
                AND
                #{endTime}
            </if>
        </where>
        ORDER BY update_time DESC
    </select>
</mapper>

```

[Mybits]:https://mybatis.org/mybatis-3/
