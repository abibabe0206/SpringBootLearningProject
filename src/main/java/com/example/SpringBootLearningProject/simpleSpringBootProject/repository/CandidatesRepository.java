package com.example.SpringBootLearningProject.simpleSpringBootProject.repository;

import com.example.SpringBootLearningProject.simpleSpringBootProject.model.employes.Employee;
import com.example.SpringBootLearningProject.simpleSpringBootProject.model.qcm.Candidates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CandidatesRepository
        extends JpaRepository<Candidates, Long> {

    @Query("SELECT c from  Candidates c where c.id = ?1")
    Optional<Candidates> findCandidatesById(Long id);

    @Query("SELECT ca FROM Candidates ca where ca.nom = ?1 and ca.categories = ?1 and ca.date = ?1")
    List<Candidates> findCandidatesByFilter(String nom, String categories, Date date);
}
