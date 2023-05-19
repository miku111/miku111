package com.studentManagement.pojo;

import lombok.Data;

@Data
public class ScoreStringEntity {
    private Integer id;
    private Integer studentId;
    private String name;
    private String courseName;
    private Integer score;
}
