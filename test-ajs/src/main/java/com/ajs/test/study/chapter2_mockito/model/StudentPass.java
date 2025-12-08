package com.ajs.test.study.chapter2_mockito.model;


import com.ajs.test.study.chapter2_mockito.controller.request.Exam;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student_pass")
@Entity
public class StudentPass {
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StudentPass that = (StudentPass) o;
        return exam == that.exam && Objects.equals(studentName, that.studentName) && Objects.equals(avgScore, that.avgScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exam, studentName, avgScore);
    }

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "exam")
    private Exam exam;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "avg_score")
    private Double avgScore;
}
