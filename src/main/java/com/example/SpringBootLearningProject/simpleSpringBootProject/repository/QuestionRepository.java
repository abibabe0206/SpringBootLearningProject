package com.example.SpringBootLearningProject.simpleSpringBootProject.repository;

import com.example.SpringBootLearningProject.simpleSpringBootProject.model.qcm.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface QuestionRepository
        extends JpaRepository<Question, Long> {

    @Query("SELECT q from  Question q where q.id = ?1")
    Optional<Question> findQuestionById(Long id);
}
