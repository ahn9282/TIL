package com.ajs.test.study.model;

import com.ajs.test.study.chapter2_mockito.controller.request.Exam;
import com.ajs.test.study.chapter2_mockito.model.StudentScore;

public class StudentTextFixture {

    public static StudentScore passed(){
        return StudentScore.builder()
                .exam(Exam.math)
                .studentName("defaultName")
                .korScore(80)
                .engScore(100)
                .mathScore(90)
                .build();
    }

    public static StudentScore failed(){
        return StudentScore.builder()
                .studentName("defaultName")
                .exam(Exam.math)
                .korScore(50)
                .engScore(50)
                .mathScore(50)
                .build();
    }

}
