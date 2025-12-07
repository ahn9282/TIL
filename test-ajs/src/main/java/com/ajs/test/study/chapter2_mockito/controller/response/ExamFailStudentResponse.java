package com.ajs.test.study.chapter2_mockito.controller.response;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExamFailStudentResponse {

    private final String studentName;
    private final Double avgScore;
}
