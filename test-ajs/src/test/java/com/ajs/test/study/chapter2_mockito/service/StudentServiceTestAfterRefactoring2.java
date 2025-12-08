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
import com.ajs.test.study.model.StudentFailFixture;
import com.ajs.test.study.model.StudentPassFixture;
import com.ajs.test.study.model.StudentScoreTestBuilder;
import com.ajs.test.study.model.StudentTextFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class StudentServiceTestAfterRefactoring2 {

    private StudentService studentService;
    private StudentScoreRepository studentScoreRepository = Mockito.mock(StudentScoreRepository.class);
    private StudentPassRepository studentPassRepository = Mockito.mock(StudentPassRepository.class);
    private StudentFailRepository studentFailRepository = Mockito.mock(StudentFailRepository.class);

    @BeforeEach
    public void beforeEachInit(){
        studentService = new StudentService(studentScoreRepository, studentPassRepository, studentFailRepository);
    }

    @Test
    @DisplayName("첫번쨰 Mock 테스트")
    public void saveScoreTest() {
        studentService.saveScore("준섭", Exam.math, 80, 70, 55);

    }

    @Test
    @DisplayName("성적 저장 로직 검증")
    public void saveScoreMockTest() {

        StudentScore expectStudentScore = StudentScoreTestBuilder.passed().build();

        StudentPass expectStudentPass = StudentPassFixture.create(expectStudentScore);

        ArgumentCaptor<StudentScore> studentScoreArgumentCaptor = ArgumentCaptor.forClass(StudentScore.class);
        ArgumentCaptor<StudentPass> studentPassArgumentCaptor = ArgumentCaptor.forClass(StudentPass.class);

        studentService.saveScore(
                expectStudentScore.getStudentName()
                , expectStudentScore.getExam()
                , expectStudentScore.getKorScore()
                , expectStudentScore.getMathScore()
                , expectStudentScore.getEngScore()
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

        StudentScore expectStudentScore = StudentTextFixture.failed();

        StudentFail expectStudentFail = StudentFailFixture.create(expectStudentScore);

        studentService.saveScore(
                expectStudentScore.getStudentName()
                , expectStudentScore.getExam()
                , expectStudentScore.getKorScore()
                , expectStudentScore.getMathScore()
                , expectStudentScore.getEngScore()
        );

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

        StudentPass expectStudent1 = StudentPassFixture.create("jsa1", Exam.math);
        StudentPass expectStudent2 = StudentPassFixture.create("jsa2", Exam.math);
        StudentPass expectStudent3 = StudentPassFixture.create("jsa3", Exam.math);

        //mock 객체인 studentPassRepository 내 findAll 호출 시 해당 값을 반환하도록 설정
        Mockito.when(studentPassRepository.findAll()).thenReturn(List.of(
                expectStudent1,
                expectStudent2,
                expectStudent3
        ));


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

        StudentFail expectStudent1 = StudentFailFixture.create("jsa1", Exam.math);
        StudentFail expectStudent2 = StudentFailFixture.create("jsa2", Exam.math);
        StudentFail notExpectStudent3 = StudentFail.builder().id(3L).studentName("im not").exam(Exam.math).avgScore(57.0).build();

        //mock 객체인 studentPassRepository 내 findAll 호출 시 해당 값을 반환하도록 설정
        Mockito.when(studentFailRepository.findAll()).thenReturn(List.of(
                expectStudent1,
                expectStudent2
        ));


        Exam exam = Exam.math;
        List<ExamFailStudentResponse> responses = studentService.getExamFailStudents(exam);
        List<ExamFailStudentResponse> expectResponses = List.of(expectStudent1, expectStudent2).stream()
                .map(r -> new ExamFailStudentResponse(r.getStudentName(), r.getAvgScore()))
                .toList();

        assertIterableEquals(expectResponses, responses);
    }
}

