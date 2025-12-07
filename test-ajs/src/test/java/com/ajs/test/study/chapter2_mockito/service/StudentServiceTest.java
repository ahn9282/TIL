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
}

