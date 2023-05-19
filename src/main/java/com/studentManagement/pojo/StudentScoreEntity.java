package com.studentManagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class StudentScoreEntity {
    private Integer id;
    private String name;
    private Integer chineseScore=0;
    private Integer mathScore=0;
    private Integer englishScore=0;
    private Integer physicsScore=0;
    private Integer chemistryScore=0;
    private Integer biologicalScore=0;

}
