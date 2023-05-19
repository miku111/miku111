package com.studentManagement.controller;

import com.github.pagehelper.PageInfo;
import com.studentManagement.mapper.ScoreMapper;
import com.studentManagement.mapper.StudentMapper;
import com.studentManagement.mapper.StudentScoreMapper;
import com.studentManagement.pojo.ScoreStringEntity;
import com.studentManagement.pojo.StudentScoreEntity;
import com.studentManagement.service.ScoreService;
import com.studentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/scores")
public class StudentScoreController {
    @Autowired
    private StudentScoreMapper studentScoreMapper;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ScoreMapper scoreMapper;
    @Autowired
    private ScoreService scoreService;
    @GetMapping
    public PageInfo<StudentScoreEntity> getAllScoreAllStudent(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize){
        List<Integer> allStudentId=studentService.selectAllId(pageNum,pageSize);
        List<StudentScoreEntity> allStudentAllScore=new ArrayList<>();

        for(Integer studentId : allStudentId){
            System.out.println(studentId);
            StudentScoreEntity studentScore=getAllScoreById(studentId);
//            if(studentScore==null){
//                return allStudentAllScore;
//            }

            allStudentAllScore.add(studentScore);
        }
        PageInfo<StudentScoreEntity> pageinfo = new PageInfo<>(allStudentAllScore);
        pageinfo.setTotal(studentService.selectAllId(null,null).size());
        //System.out.println(studentService.selectAllId(null,null).size());
        pageinfo.setPageNum(pageNum);
        pageinfo.setSize(pageSize);
        return pageinfo;
    }
    @DeleteMapping("/students/{studentId}")
    public String deleteScoreByStudentId(@PathVariable Integer studentId){
        boolean result=scoreService.deleteScore(studentId);

            return "成功";

//return "失败";
    }

    @GetMapping("/students/{studentId}")
    public StudentScoreEntity getAllScoreById(@PathVariable Integer studentId){

        List<ScoreStringEntity> scoreStringEntities = studentScoreMapper.selectAllScoreById(studentId);
        if(scoreStringEntities.size()==0){
            String name=studentService.selectOne(studentId).getName();
            StudentScoreEntity studentScore=new StudentScoreEntity(studentId,name,0,0,0,0,0,0);

            System.out.println("不存在此学生的成绩");
            return studentScore;
        }
            StudentScoreEntity studentScore=new StudentScoreEntity();
            studentScore.setId(studentId);
            studentScore.setName(scoreStringEntities.get(0).getName());
        System.out.println(scoreStringEntities);
            for(ScoreStringEntity score : scoreStringEntities){
                String courseName=score.getCourseName();
                switch (courseName){
                    case "语文": studentScore.setChineseScore(score.getScore());break;
                    case "数学":studentScore.setMathScore(score.getScore());break;
                    case"英语":studentScore.setEnglishScore(score.getScore());break;
                    case"物理":studentScore.setPhysicsScore(score.getScore());break;
                    case"化学":studentScore.setChemistryScore(score.getScore());break;
                    case"生物":studentScore.setBiologicalScore(score.getScore());
                }
            }
            return  studentScore;
    }
    @PostMapping
    public String createStudentScore(@RequestBody StudentScoreEntity studentScore){
        Integer studentId=studentScore.getId();
        //System.out.println(studentId);
        if(studentService.selectOne(studentId)==null){
return "学生不存在，请创建学生";
        }

        scoreService.createScore(studentScore);


return  "成功";
    }

    @PutMapping
    public String updateStudentScore(@RequestBody StudentScoreEntity studentScore){
        Integer studentId=studentScore.getId();
        if(studentService.selectOne(studentId)==null){
            return "学生不存在，请创建学生";
        }


        scoreService.updateScore(studentScore);


        return  "成功";
    }
    @GetMapping("/subjects/{courseName}")
    public List<ScoreStringEntity> getAllScoreBySubject(@PathVariable String courseName){
        List<ScoreStringEntity> allScoreOfSubject = new ArrayList<>();
        switch (courseName){
            case "chinese":  allScoreOfSubject= scoreMapper.selectAllScoreByCourse(1)  ;break;
            case "math":allScoreOfSubject= scoreMapper.selectAllScoreByCourse(2) ;break;
            case"english":allScoreOfSubject= scoreMapper.selectAllScoreByCourse(3) ;break;
            case"physics":allScoreOfSubject =scoreMapper.selectAllScoreByCourse(4) ;break;
            case"chemistry":allScoreOfSubject =scoreMapper.selectAllScoreByCourse(5) ;break;
            case"biological":allScoreOfSubject =scoreMapper.selectAllScoreByCourse(6) ;
        }
        return allScoreOfSubject;
    }
}
