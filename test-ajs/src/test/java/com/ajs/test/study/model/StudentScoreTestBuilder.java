package com.ajs.test.study.model;

import com.ajs.test.study.chapter2_mockito.controller.request.Exam;
import com.ajs.test.study.chapter2_mockito.model.StudentPass;
import com.ajs.test.study.chapter2_mockito.model.StudentScore;

public class StudentScoreTestBuilder {

    public static StudentScore.StudentScoreBuilder passed(){
        return StudentScore.builder()
                .korScore(80)
                .engScore(100)
                .mathScore(90)
                .studentName("defaultName")
                .exam(Exam.math)
                ;
    }

}
