package com.studentManagement.mapper;

import com.studentManagement.pojo.ScoreStringEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ScoreMapper {
    @Select("SELECT scores.id,students.id as studentId,students.name, courses.name as courseName, scores.score FROM `scores` join students on students.id=scores.studentId join courses on scores.courseId=courses.id where courseId=#{courseId}")
    List<ScoreStringEntity> selectAllScoreByCourse(Integer courseId);
    @Insert("insert into scores values(null,#{arg0},#{arg1},#{arg2})")
    boolean insertScore(Integer studentId,Integer courseId,Integer score);
    @Update("update scores set score=#{arg0} where studentId=#{arg1} and courseId=#{arg2} ")
    boolean updateScore(Integer score,Integer studentId,Integer courseId);
    @Delete("delete from scores where studentId=#{studentId}")
    boolean deleteScore(Integer studentId);
    @Select("select courseId from scores where studentId=#{studentId}")
    List<Integer> selectCourseById(Integer studentId);
}
