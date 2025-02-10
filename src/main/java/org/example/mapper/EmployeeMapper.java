package org.example.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import org.example.model.Employee;

public interface EmployeeMapper {
    @Delete({
        "delete from employee",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into employee (id, name, ",
        "age, department)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{age,jdbcType=INTEGER}, #{department,jdbcType=INTEGER})"
    })
    int insert(Employee row);

    @Select({
        "select",
        "id, name, age, department",
        "from employee",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="department", property="department", jdbcType=JdbcType.INTEGER)
    })
    Employee selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, name, age, department",
        "from employee"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="department", property="department", jdbcType=JdbcType.INTEGER)
    })
    List<Employee> selectAll();

    @Update({
        "update employee",
        "set name = #{name,jdbcType=VARCHAR},",
          "age = #{age,jdbcType=INTEGER},",
          "department = #{department,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Employee row);
}