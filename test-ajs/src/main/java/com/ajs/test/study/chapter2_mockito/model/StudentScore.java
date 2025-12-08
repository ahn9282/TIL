package com.ajs.test.study.chapter2_mockito.model;


import com.ajs.test.study.chapter2_mockito.controller.request.Exam;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Getter
@Service
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student_score")
@Entity
public class StudentScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_score_id")
    private Long id;

    @Column(name = "exam")
    @Enumerated(EnumType.STRING)
    private Exam exam;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "kor_score")
    private Integer korScore;

    @Column(name = "english_score")
    private Integer engScore;

    @Column(name = "math_score")
    private Integer mathScore;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StudentScore that = (StudentScore) o;
        return exam == that.exam && Objects.equals(studentName, that.studentName) && Objects.equals(korScore, that.korScore) && Objects.equals(engScore, that.engScore) && Objects.equals(mathScore, that.mathScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exam, studentName, korScore, engScore, mathScore);
    }
}
