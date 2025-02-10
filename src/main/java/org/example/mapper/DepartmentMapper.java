package org.example.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import org.example.model.Department;

public interface DepartmentMapper {
    @Delete({
        "delete from department",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into department (id, dname, ",
        "location)",
        "values (#{id,jdbcType=INTEGER}, #{dname,jdbcType=VARCHAR}, ",
        "#{location,jdbcType=VARCHAR})"
    })
    int insert(Department row);

    @Select({
        "select",
        "id, dname, location",
        "from department",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="dname", property="dname", jdbcType=JdbcType.VARCHAR),
        @Result(column="location", property="location", jdbcType=JdbcType.VARCHAR)
    })
    Department selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, dname, location",
        "from department"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="dname", property="dname", jdbcType=JdbcType.VARCHAR),
        @Result(column="location", property="location", jdbcType=JdbcType.VARCHAR)
    })
    List<Department> selectAll();

    @Update({
        "update department",
        "set dname = #{dname,jdbcType=VARCHAR},",
          "location = #{location,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Department row);
}