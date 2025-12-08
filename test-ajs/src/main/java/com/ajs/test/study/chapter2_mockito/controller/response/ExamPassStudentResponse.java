package com.ajs.test.study.chapter2_mockito.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class ExamPassStudentResponse {
    private final String studentName;
    private final Double avgScore;

}
