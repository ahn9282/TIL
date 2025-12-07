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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentScoreRepository scoreRepository;
    private final StudentPassRepository passRepository;
    private final StudentFailRepository failRepository;


    public void saveScore(String studentName, Exam exam, Integer korScore, Integer mathScore, Integer engScore) {

        StudentScore studentScore = StudentScore.builder()
                .exam(exam)
                .studentName(studentName)
                .korScore(korScore)
                .mathScore(mathScore)
                .engScore(engScore)
                .build();

        scoreRepository.save(studentScore);

        MyCalculator calculator = new MyCalculator(0.0);
        Double avgScore = calculator
                .add(korScore.doubleValue())
                .add(engScore.doubleValue())
                .add(mathScore.doubleValue())
                .divide(3.0)
                .getResult();

        if(avgScore >= 60.0){
            passRepository.save(StudentPass.builder()
                    .exam(exam)
                    .studentName(studentName)
                    .avgScore(avgScore)
                    .build());
        } else {
            failRepository.save(StudentFail.builder()
                    .exam(exam)
                    .studentName(studentName)
                    .avgScore(avgScore)
                    .build());
        }
    }

    public List<ExamPassStudentResponse> getExamPassStudents(Exam exam) {
        List<StudentPass> all = passRepository.findAll();

        return all.stream()
                .filter(pass -> pass.getExam().equals(exam))
                .map(pass -> new ExamPassStudentResponse(pass.getStudentName(), pass.getAvgScore()))
                .toList();
    }
    public List<ExamFailStudentResponse> getExamFailStudents(Exam exam) {
        List<StudentFail> all = failRepository.findAll();

        return all.stream()
                .filter(pass -> pass.getExam().equals(exam))
                .map(pass -> new ExamFailStudentResponse(pass.getStudentName(), pass.getAvgScore()))
                .toList();
    }
}
