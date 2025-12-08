package com.ajs.test.study.model;

import com.ajs.test.study.chapter1_junit.MyCalculator;
import com.ajs.test.study.chapter2_mockito.controller.request.Exam;
import com.ajs.test.study.chapter2_mockito.model.StudentFail;
import com.ajs.test.study.chapter2_mockito.model.StudentPass;
import com.ajs.test.study.chapter2_mockito.model.StudentScore;

public class StudentFailFixture {

    public static StudentFail create(StudentScore studentScore) {
        MyCalculator calculator = new MyCalculator();

        return StudentFail.builder()
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


    public static StudentFail create(String studentName, Exam exam) {
        return StudentFail.builder()
                .studentName(studentName)
                .exam(exam)
                .avgScore(50.0)
                .build();
    }
}
