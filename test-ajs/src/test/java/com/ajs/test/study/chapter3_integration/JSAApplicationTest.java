package com.ajs.test.study.chapter3_integration;


import com.ajs.test.study.chapter2_mockito.model.repository.StudentScoreRepository;
import com.ajs.test.study.model.StudentTextFixture;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

public class JSAApplicationTest extends IntegrationTest{


    @Autowired
    private StudentScoreRepository studentScoreRepository;
    @Autowired
    private EntityManager em;

    @Test
    public void contextLoads(){
        var studentScore = new StudentTextFixture().passed();
        var savedStudentScore = studentScoreRepository.save(studentScore);

        em.flush();
        em.clear();

        var queryStudentScore = studentScoreRepository.findById(savedStudentScore.getId()).orElseThrow();
        System.out.println(queryStudentScore.getId());

        assertEquals(savedStudentScore.getId(), queryStudentScore.getId());
        assertEquals(savedStudentScore.getExam(), queryStudentScore.getExam());
        assertEquals(savedStudentScore.getKorScore(), queryStudentScore.getKorScore());
        assertEquals(savedStudentScore.getMathScore(), queryStudentScore.getMathScore());
        assertEquals(savedStudentScore.getEngScore(), queryStudentScore.getEngScore());
    }
}
