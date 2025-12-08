package com.ajs.test.study.model;

import com.ajs.test.study.chapter1_junit.MyCalculator;
import com.ajs.test.study.chapter2_mockito.controller.request.Exam;
import com.ajs.test.study.chapter2_mockito.model.StudentPass;
import com.ajs.test.study.chapter2_mockito.model.StudentScore;

public class StudentPassFixture {

    public static StudentPass create(StudentScore studentScore) {
        MyCalculator calculator = new MyCalculator();

        return StudentPass.builder()
                .studentName(studentScore.getStudentName())
                .exam(studentScore.getExam())
                .avgScore(calculator
                        .add(studentScore.getKorScore().doubleValue())
                        .add(studentScore.getEngScore().doubleValue())
                        .add(studentScore.getMathScore().doubleValue())
                        .divide(3.0).getResult()
                )
                .build();
    }

    public static StudentPass create(String studentName, Exam exam) {
        return StudentPass.builder()
                .studentName(studentName)
                .exam(exam)
                .avgScore(80.0)
                .build();
    }
}
