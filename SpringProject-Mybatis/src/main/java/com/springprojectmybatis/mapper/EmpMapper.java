package com.springprojectmybatis.mapper;

import com.springprojectmybatis.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    // 删除功能
    @Delete("delete from emp where id = #{id}")
    void delete(Integer id);

    // 插入功能
    @Options(keyProperty = "id", useGeneratedKeys = true)
    @Insert("insert into emp(username, name, image, job, entry_time, create_time, update_time)" +
            "  values (#{username},#{name},#{image},#{job},#{entryTime},#{createTime},#{updateTime});")
    void insert(Emp emp);

    // 更新功能
    @Update("UPDATE emp SET username = #{username}, name = #{name}, image = #{image}, job = #{job}, " +
            "update_time = #{updateTime} WHERE id = #{id}")
    void update(Emp emp);

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
    @Select("select id, username, password, name, gender, image, job, entry_time, create_time, update_time" +
            " from emp where id = #{id}")
    Emp getByID(Integer id);

    // name 字段需要实现模糊搜索
    // 1. 字符串中使用 ${} 替换 #{}, 会产生安全问题
    // 2. 通过 sql 中的 concat() 实现
    //    @Select("SELECT * FROM emp WHERE name LIKE CONCAT('%', #{name}, '%') AND gender = #{gender} " +
    //            "AND entry_time BETWEEN #{startTime} AND #{endTime} ORDER BY update_time DESC")
    List<Emp> select(String name, Short gender, LocalDate startTime, LocalDate endTime);


    void updateInfo(Emp emp);


    //    批量删除
    void deleteByIds(List<Integer> ids);
}
