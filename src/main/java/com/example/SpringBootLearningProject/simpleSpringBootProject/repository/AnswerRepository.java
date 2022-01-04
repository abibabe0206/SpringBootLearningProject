package com.example.SpringBootLearningProject.simpleSpringBootProject.repository;

import com.example.SpringBootLearningProject.simpleSpringBootProject.model.qcm.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AnswerRepository
        extends JpaRepository<Answer, Long> {

    @Query("SELECT a from  Answer a where a.id = ?1")
    Optional<Answer> findAnswerById(Long id);
}
