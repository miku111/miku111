package com.studentManagement.pojo;

import lombok.Data;

@Data
public class ScoreEntity {
    private Integer id;
    private Integer studentId;
    private Integer courseId;
    private Integer score;
}
