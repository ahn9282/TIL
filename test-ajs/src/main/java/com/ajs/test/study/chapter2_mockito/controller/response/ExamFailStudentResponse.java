package com.ajs.test.study.chapter2_mockito.controller.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class ExamFailStudentResponse {

    private final String studentName;
    private final Double avgScore;
}
