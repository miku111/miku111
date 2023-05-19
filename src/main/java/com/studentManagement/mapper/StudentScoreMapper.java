package com.studentManagement.mapper;

import com.studentManagement.pojo.ScoreEntity;
import com.studentManagement.pojo.ScoreStringEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentScoreMapper {
    @Select("SELECT s.id, s.studentId,students.name, c.name as coursename, s.score  FROM scores s JOIN courses c ON s.courseId = c.id JOIN  students on s.studentId = students.id  WHERE s.studentId = #{studentId}")
    List<ScoreStringEntity> selectAllScoreById(Integer studentId);

}
