package com.ajs.test.study.chapter2_mockito.controller;


import com.ajs.test.study.chapter2_mockito.controller.request.Exam;
import com.ajs.test.study.chapter2_mockito.controller.request.SaveExamScoreRequest;
import com.ajs.test.study.chapter2_mockito.controller.response.ExamFailStudentResponse;
import com.ajs.test.study.chapter2_mockito.controller.response.ExamPassStudentResponse;
import com.ajs.test.study.chapter2_mockito.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScoreApi {
    private final StudentService studentService;

    @PutMapping("/exam/{exam}/score")
    public Object save(@RequestBody SaveExamScoreRequest request, @PathVariable Exam exam) {

        studentService.saveScore(request.getStudentName()
                , exam, request.getKorScore()
                , request.getMathScore()
                , request.getEngScore());

        return request;
    }

    @GetMapping("/exam/{exam}/pass")
    public List<ExamPassStudentResponse> pass(@PathVariable Exam exam) {

        return studentService.getExamPassStudents(exam);
    }

    @GetMapping("/exam/{exam}/fail")
    public List<ExamFailStudentResponse> fail(@PathVariable Exam exam) {

        return studentService.getExamFailStudents(exam);
    }
}
