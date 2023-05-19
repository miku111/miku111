package com.studentManagement.mapper;

import com.studentManagement.pojo.StudentEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface StudentMapper {
@Select("select * from students")
List<StudentEntity> selectAll();
    @Select("select * from students")
    List<StudentEntity> selectByPage();
@Select("select id from students")
List<Integer> selectAllId();
@Select("select * from students where id=#{id}")
  StudentEntity  selectOne(Integer id);
@Delete("delete from students where id=#{id}")
    boolean deleteOne(Integer id);
@Update("update students set name = #{name},gender=#{gender},age=#{age} where id=#{id}")
    boolean updateOne(StudentEntity student);
    @Insert("insert into students values(null,#{name},#{gender},#{age}) ")
    boolean createOne(StudentEntity student);
    @Select("select * from students where age<#{age}")
    List<StudentEntity> selectByAgeLessThan(Integer age);
    @Select("select * from students where age>#{age}")
    List<StudentEntity> selectByAgeLargeThan(Integer age);
    @Select("select * from students where age>#{arg0} and age<#{arg1}")
    List<StudentEntity> selectByAgeBetween(Integer minAge,Integer maxAge);
}
