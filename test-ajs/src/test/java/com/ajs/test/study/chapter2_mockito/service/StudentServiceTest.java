package com.ajs.test.study.chapter2_mockito.service;

import com.ajs.test.study.chapter2_mockito.controller.request.Exam;
import com.ajs.test.study.chapter2_mockito.model.repository.StudentFailRepository;
import com.ajs.test.study.chapter2_mockito.model.repository.StudentPassRepository;
import com.ajs.test.study.chapter2_mockito.model.repository.StudentScoreRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StudentServiceTest {


    @Test
    @DisplayName("첫번쨰 Mock 테스트")
    public void saveScoreTest() {
        StudentService studentScoreService = new StudentService(
                Mockito.mock(StudentScoreRepository.class),
                Mockito.mock(StudentPassRepository.class),
                Mockito.mock(StudentFailRepository.class)
        );

        studentScoreService.saveScore("준섭", Exam.math, 80, 70, 55);

    }

    @Test
    @DisplayName("성적 저장 로직 검증")
    public void saveScoreMockTest() {
        StudentScoreRepository studentScoreRepository = Mockito.mock(StudentScoreRepository.class);
        StudentPassRepository studentPassRepository = Mockito.mock(StudentPassRepository.class);
        StudentFailRepository studentFailRepository = Mockito.mock(StudentFailRepository.class);

        StudentService studentService = new StudentService(
                studentScoreRepository
                , studentPassRepository
                , studentFailRepository
        );
        String givenStudentName = "jsa";
        Exam givenExam = Exam.math;
        Integer givenKorScore = 80;
        Integer givenEngScore = 70;
        Integer givenMathScore = 60;

        studentService.saveScore(
                givenStudentName
                , givenExam
                , givenKorScore
                , givenMathScore
                , givenEngScore
        );

        Mockito.verify(studentScoreRepository, Mockito.times(1)).save(Mockito.any());
        Mockito.verify(studentPassRepository, Mockito.times(1)).save(Mockito.any());
        Mockito.verify(studentFailRepository, Mockito.times(0)).save(Mockito.any());
    }

    @Test
    @DisplayName("성적 저장 60 점 미만인 경우")
    public void saveScoreFailTest(){
        StudentScoreRepository studentScoreRepository = Mockito.mock(StudentScoreRepository.class);
        StudentPassRepository studentPassRepository = Mockito.mock(StudentPassRepository.class);
        StudentFailRepository studentFailRepository = Mockito.mock(StudentFailRepository.class);

        StudentService studentService = new StudentService(
                studentScoreRepository
                , studentPassRepository
                , studentFailRepository
        );
        String givenStudentName = "jsa";
        Exam givenExam = Exam.math;
        Integer givenKorScore = 60;
        Integer givenEngScore = 40;
        Integer givenMathScore = 55;
        studentService.saveScore(givenStudentName, givenExam, givenKorScore, givenMathScore, givenEngScore);

        Mockito.verify(studentScoreRepository, Mockito.times(1)).save(Mockito.any());
        Mockito.verify(studentPassRepository, Mockito.times(0)).save(Mockito.any());
        Mockito.verify(studentFailRepository, Mockito.times(1)).save(Mockito.any());
    }
}

