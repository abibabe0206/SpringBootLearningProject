package com.example.SpringBootLearningProject.simpleSpringBootProject.repository;

import com.example.SpringBootLearningProject.simpleSpringBootProject.model.qcm.TestQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TestQuestionRepository
        extends JpaRepository<TestQuestion, Long> {

    @Query("SELECT t from  TestQuestion t where t.id = ?1")
    Optional<TestQuestion> findTestQuestionById(Long id);
}
