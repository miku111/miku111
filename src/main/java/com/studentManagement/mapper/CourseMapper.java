package com.studentManagement.mapper;

import com.studentManagement.pojo.CourseEntity;
import com.studentManagement.pojo.StudentEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseMapper {
    @Select("select * from courses")
    List<CourseEntity> selectAll();
    @Select("select * from courses where id=#{id}")
    CourseEntity selectOne(Integer id);
    @Delete("delete from courses where id=#{id}")
    boolean deleteOne();
    @Update("update courses set name = #{name} where id=#{id}")
    boolean updateOne(CourseEntity course);
    @Insert("insert into courses values(null,#{name})")
    boolean createOne(CourseEntity course);
}
