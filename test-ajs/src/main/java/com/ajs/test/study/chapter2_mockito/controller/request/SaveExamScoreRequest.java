package com.ajs.test.study.chapter2_mockito.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SaveExamScoreRequest {
    private final String studentName;
    private final Integer korScore;
    private final Integer engScore;
    private final Integer mathScore;
}