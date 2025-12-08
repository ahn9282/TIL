package com.ajs.test.study.chapter2_mockito.service;

import com.ajs.test.study.chapter1_junit.MyCalculator;
import com.ajs.test.study.chapter2_mockito.controller.request.Exam;
import com.ajs.test.study.chapter2_mockito.controller.response.ExamFailStudentResponse;
import com.ajs.test.study.chapter2_mockito.controller.response.ExamPassStudentResponse;
import com.ajs.test.study.chapter2_mockito.model.StudentFail;
import com.ajs.test.study.chapter2_mockito.model.StudentPass;
import com.ajs.test.study.chapter2_mockito.model.StudentScore;
import com.ajs.test.study.chapter2_mockito.model.repository.StudentFailRepository;
import com.ajs.test.study.chapter2_mockito.model.repository.StudentPassRepository;
import com.ajs.test.study.chapter2_mockito.model.repository.StudentScoreRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        StudentScore expectStudentScore = StudentScore.builder()
                .studentName(givenStudentName)
                .exam(givenExam)
                .korScore(givenKorScore)
                .engScore(givenEngScore)
                .mathScore(givenMathScore)
                .build();
        MyCalculator myCalculator = new MyCalculator(0.0);
        Double givenAvgScore = myCalculator.add(givenKorScore.doubleValue())
                .add(givenEngScore.doubleValue())
                .add(givenMathScore.doubleValue())
                .divide(3.0)
                .getResult();
        StudentPass expectStudentPass = StudentPass.builder()
                .studentName(givenStudentName)
                .exam(givenExam)
                .avgScore(givenAvgScore)
                .build();

        ArgumentCaptor<StudentScore> studentScoreArgumentCaptor = ArgumentCaptor.forClass(StudentScore.class);
        ArgumentCaptor<StudentPass> studentPassArgumentCaptor = ArgumentCaptor.forClass(StudentPass.class);

        studentService.saveScore(
                givenStudentName
                , givenExam
                , givenKorScore
                , givenMathScore
                , givenEngScore
        );

        Mockito.verify(studentScoreRepository, Mockito.times(1)).save(studentScoreArgumentCaptor.capture());
        StudentScore capturedStudentScore = studentScoreArgumentCaptor.getValue();
        assertEquals(expectStudentScore, capturedStudentScore);
        assertEquals(expectStudentScore.getStudentName(), expectStudentScore.getStudentName());
        assertEquals(expectStudentScore.getKorScore(), expectStudentScore.getKorScore());
        assertEquals(expectStudentScore.getEngScore(), expectStudentScore.getEngScore());
        assertEquals(expectStudentScore.getMathScore(), expectStudentScore.getMathScore());

        Mockito.verify(studentPassRepository, Mockito.times(1)).save(studentPassArgumentCaptor.capture());

        StudentPass capturedStudentPass = studentPassArgumentCaptor.getValue();
        assertEquals(expectStudentPass, capturedStudentPass);
        assertEquals(expectStudentPass.getStudentName(), capturedStudentPass.getStudentName());
        assertEquals(expectStudentPass.getAvgScore(), capturedStudentPass.getAvgScore());

        Mockito.verify(studentFailRepository, Mockito.times(0)).save(Mockito.any());

        assertEquals(expectStudentPass, capturedStudentPass);
    }

    @Test
    @DisplayName("성적 저장 60 점 미만인 경우")
    public void saveScoreFailTest() {
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

        StudentScore expectStudentScore = StudentScore.builder()
                .studentName(givenStudentName)
                .exam(givenExam)
                .korScore(givenKorScore)
                .engScore(givenEngScore)
                .mathScore(givenMathScore)
                .build();

        StudentFail expectStudentFail = StudentFail.builder()
                .studentName(givenStudentName)
                .exam(givenExam)
                .avgScore(
                        (new MyCalculator(0.0))
                                .add(givenKorScore.doubleValue())
                                .add(givenEngScore.doubleValue())
                                .add(givenMathScore.doubleValue())
                                .divide(3.0)
                                .getResult())
                .build();

        ArgumentCaptor<StudentScore> studentScoreArgumentCaptor = ArgumentCaptor.forClass(StudentScore.class);
        ArgumentCaptor<StudentFail> studentFailArgumentCaptor = ArgumentCaptor.forClass(StudentFail.class);

        Mockito.verify(studentScoreRepository, Mockito.times(1)).save(studentScoreArgumentCaptor.capture());
        StudentScore capturedStudentScore = studentScoreArgumentCaptor.getValue();
        assertEquals(expectStudentScore, capturedStudentScore);
        assertEquals(expectStudentScore.getStudentName(), expectStudentScore.getStudentName());
        assertEquals(expectStudentScore.getKorScore(), expectStudentScore.getKorScore());
        assertEquals(expectStudentScore.getEngScore(), expectStudentScore.getEngScore());
        assertEquals(expectStudentScore.getMathScore(), expectStudentScore.getMathScore());

        Mockito.verify(studentPassRepository, Mockito.times(0)).save(Mockito.any());

        Mockito.verify(studentFailRepository, Mockito.times(1)).save(studentFailArgumentCaptor.capture());
        StudentFail capturedStudentFail = studentFailArgumentCaptor.getValue();
        assertEquals(expectStudentFail, capturedStudentFail);
        assertEquals(expectStudentFail.getStudentName(), capturedStudentFail.getStudentName());
        assertEquals(expectStudentFail.getAvgScore(), capturedStudentFail.getAvgScore());

    }

    @Test
    @DisplayName("합격자 명단 가져오기")
    public void getPassStudentTest() {
        StudentScoreRepository studentScoreRepository = Mockito.mock(StudentScoreRepository.class);
        StudentPassRepository studentPassRepository = Mockito.mock(StudentPassRepository.class);
        StudentFailRepository studentFailRepository = Mockito.mock(StudentFailRepository.class);

        StudentPass expectStudent1 = StudentPass.builder().id(1L).studentName("jsa1").exam(Exam.math).avgScore(80.0).build();
        StudentPass expectStudent2 = StudentPass.builder().id(2L).studentName("jsa2").exam(Exam.math).avgScore(68.0).build();
        StudentPass expectStudent3 = StudentPass.builder().id(3L).studentName("jsa3").exam(Exam.math).avgScore(67.0).build();

        //mock 객체인 studentPassRepository 내 findAll 호출 시 해당 값을 반환하도록 설정
        Mockito.when(studentPassRepository.findAll()).thenReturn(List.of(
                StudentPass.builder().id(1L).studentName("jsa1").exam(Exam.math).avgScore(80.0).build(),
                StudentPass.builder().id(2L).studentName("jsa2").exam(Exam.math).avgScore(68.0).build(),
                StudentPass.builder().id(3L).studentName("jsa3").exam(Exam.math).avgScore(67.0).build()
        ));

        StudentService studentService = new StudentService(
                studentScoreRepository
                , studentPassRepository
                , studentFailRepository
        );

        Exam exam = Exam.math;
        List<ExamPassStudentResponse> responses = studentService.getExamPassStudents(exam);
        List<ExamPassStudentResponse> expectResponses = List.of(expectStudent1, expectStudent2, expectStudent3).stream()
                .map(r -> new ExamPassStudentResponse(r.getStudentName(), r.getAvgScore()))
                .toList();

        assertIterableEquals(expectResponses, responses);
    }

    @Test
    @DisplayName("불합격자 명단 가져오기 검증")
    public void getFailStudentTest() {
        StudentScoreRepository studentScoreRepository = Mockito.mock(StudentScoreRepository.class);
        StudentPassRepository studentPassRepository = Mockito.mock(StudentPassRepository.class);
        StudentFailRepository studentFailRepository = Mockito.mock(StudentFailRepository.class);

        StudentFail expectStudent1 = StudentFail.builder().id(1L).studentName("jsa1").exam(Exam.math).avgScore(30.0).build();
        StudentFail expectStudent2 = StudentFail.builder().id(2L).studentName("jsa2").exam(Exam.math).avgScore(48.0).build();
        StudentFail notExpectStudent3 = StudentFail.builder().id(3L).studentName("im not").exam(Exam.math).avgScore(57.0).build();

        //mock 객체인 studentPassRepository 내 findAll 호출 시 해당 값을 반환하도록 설정
        Mockito.when(studentFailRepository.findAll()).thenReturn(List.of(
                StudentFail.builder().id(1L).studentName("jsa1").exam(Exam.math).avgScore(30.0).build(),
                StudentFail.builder().id(2L).studentName("jsa2").exam(Exam.math).avgScore(48.0).build()
        ));

        StudentService studentService = new StudentService(
                studentScoreRepository
                , studentPassRepository
                , studentFailRepository
        );

        Exam exam = Exam.math;
        List<ExamFailStudentResponse> responses = studentService.getExamFailStudents(exam);
        List<ExamFailStudentResponse> expectResponses = List.of(expectStudent1, expectStudent2).stream()
                .map(r -> new ExamFailStudentResponse(r.getStudentName(), r.getAvgScore()))
                .toList();

        assertIterableEquals(expectResponses, responses);
    }
}

