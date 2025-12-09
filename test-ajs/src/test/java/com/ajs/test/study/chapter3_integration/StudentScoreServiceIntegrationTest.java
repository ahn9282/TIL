package com.ajs.test.study.chapter3_integration;

import com.ajs.test.study.chapter1_junit.MyCalculator;
import com.ajs.test.study.chapter2_mockito.service.StudentService;
import com.ajs.test.study.model.StudentTextFixture;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentScoreServiceIntegrationTest extends IntegrationTest{
    @Autowired
    private StudentService studentService;
    @Autowired
    private EntityManager em;

    @Test
    public void savePassedStudentScoreTest(){
        var studentScore = StudentTextFixture.passed();

        studentService.saveScore(
                studentScore.getStudentName(),
                studentScore.getExam(),
                studentScore.getKorScore(),
                studentScore.getMathScore(),
                studentScore.getEngScore()
        );

        em.flush();
        em.clear();

        var passedStudentResponses = studentService.getExamPassStudents(studentScore.getExam());

        Assertions.assertEquals(1, passedStudentResponses.size());

        var passedStudentResponse = passedStudentResponses.get(1);

        MyCalculator myCalculator = new MyCalculator(0.0);

        Assertions.assertEquals(studentScore.getStudentName(), passedStudentResponse.getStudentName());
        Assertions.assertEquals(
                myCalculator
                    .add(studentScore.getKorScore().doubleValue())
                    .add(studentScore.getEngScore().doubleValue())
                    .add(studentScore.getMathScore().doubleValue())
                        .divide(3.0)
                    .getResult()
                , passedStudentResponse.getAvgScore());
    }

    @Test
    public void saveFailedStudentScoreTest() {
        var studentScore = StudentTextFixture.failed();

        studentService.saveScore(
                studentScore.getStudentName()
                ,studentScore.getExam()
                , studentScore.getKorScore()
                , studentScore.getMathScore()
                , studentScore.getEngScore()
        );

        em.flush();
        em.clear();

        var failedStudentResponses = studentService.getExamFailStudents(studentScore.getExam());

        Assertions.assertEquals(1, failedStudentResponses.size());

        var failedStudentResponse = failedStudentResponses.get(1);

        MyCalculator myCalculator = new MyCalculator(0.0);

        Assertions.assertEquals(
                myCalculator
                        .add(studentScore.getKorScore().doubleValue())
                        .add(studentScore.getEngScore().doubleValue())
                        .add(studentScore.getMathScore().doubleValue())
                        .divide(3.0)
                        .getResult()
                , failedStudentResponse.getAvgScore());

    }
}
