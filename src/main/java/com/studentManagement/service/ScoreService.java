package com.studentManagement.service;

import com.studentManagement.mapper.ScoreMapper;
import com.studentManagement.pojo.StudentScoreEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;
    public boolean createScore(StudentScoreEntity studentScore){
        Integer studentId=studentScore.getId();
        Integer chineseScore=studentScore.getChineseScore();
        scoreMapper.insertScore(studentId,1,chineseScore);
        Integer  mathScore=studentScore.getMathScore();
        scoreMapper.insertScore(studentId,2,mathScore);
        Integer englishScore=studentScore.getEnglishScore();
        scoreMapper.insertScore(studentId,3,englishScore);
        Integer physicsScore=studentScore.getPhysicsScore();
        scoreMapper.insertScore(studentId,4,physicsScore);
        Integer chemistryScore=studentScore.getChemistryScore();
        scoreMapper.insertScore(studentId,5,chemistryScore);
        Integer biologicalScore=studentScore.getBiologicalScore();
        scoreMapper.insertScore(studentId,6,biologicalScore);
        return true;
    }
    public boolean updateScore(StudentScoreEntity studentScore){
//        List<Integer> allCourse = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
//        List<Integer> studentCourseId=scoreMapper.selectCourseById(studentScore.getId());
//        if(studentCourseId!=null){
//
//            allCourse.removeAll(studentCourseId);
//
//        }else{
//
//            this.createScore(studentScore);
//        }


        Integer studentId=studentScore.getId();
        Integer chineseScore=studentScore.getChineseScore();
        if(!scoreMapper.updateScore(chineseScore,studentId,1)){
            scoreMapper.insertScore(studentId,1,chineseScore);
        }
        Integer  mathScore=studentScore.getMathScore();
        if(!scoreMapper.updateScore(mathScore,studentId,2)){
            scoreMapper.insertScore(studentId,2,mathScore);
        }
        Integer englishScore=studentScore.getEnglishScore();
        if(!scoreMapper.updateScore(englishScore,studentId,3)){
            scoreMapper.insertScore(studentId,3,englishScore);
        }
        Integer physicsScore=studentScore.getPhysicsScore();
       if(!scoreMapper.updateScore(physicsScore,studentId,4)){
           scoreMapper.insertScore(studentId,4,physicsScore);
       }
        Integer chemistryScore=studentScore.getChemistryScore();
       if(!scoreMapper.updateScore(chemistryScore,studentId,5)){
           scoreMapper.insertScore(studentId,5,chemistryScore);
       }
        Integer biologicalScore=studentScore.getBiologicalScore();
       if(!scoreMapper.updateScore(biologicalScore,studentId,6)){
           scoreMapper.insertScore(studentId,6,biologicalScore);
       }
        return true;
    }
    public boolean deleteScore(Integer studentId){
return scoreMapper.deleteScore(studentId);
    }
}
