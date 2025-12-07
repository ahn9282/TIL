package com.ajs.test.study.chapter2_mockito.model.repository;

import com.ajs.test.study.chapter2_mockito.model.StudentFail;
import com.ajs.test.study.chapter2_mockito.model.StudentScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentFailRepository extends JpaRepository<StudentFail, Long> {
}
