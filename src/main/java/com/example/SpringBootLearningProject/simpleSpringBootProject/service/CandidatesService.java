package com.example.SpringBootLearningProject.simpleSpringBootProject.service;


import com.example.SpringBootLearningProject.simpleSpringBootProject.exception.UserNotFoundException;
import com.example.SpringBootLearningProject.simpleSpringBootProject.model.qcm.Candidates;
import com.example.SpringBootLearningProject.simpleSpringBootProject.model.qcm.SearchParametersDTO;
import com.example.SpringBootLearningProject.simpleSpringBootProject.repository.CandidatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CandidatesService {
    
    private final CandidatesRepository candidatesRepository;
    
    
    @Autowired
    public CandidatesService(CandidatesRepository candidatesRepository) {
        this.candidatesRepository = candidatesRepository;
    }

    /**
     *  creates new Candidates
     * @param candidates
     */
    public Candidates addNewCandidates(Candidates candidates) {
        return candidatesRepository.save(candidates);
    }

    /**
     *
     * @return all Candidates
     */
    public List<Candidates> getCandidates() {

        return candidatesRepository.findAll();
    }

    /**
     *
     * @param params
     * @return
     */
    public List<Candidates> findCandidatesByFilter(SearchParametersDTO params) {
        return candidatesRepository.findCandidatesByFilter(params.getNom(), params.getCategories(), params.getDate());
    };

    /**
     *
     * @param candidates
     * @return
     */
    public Candidates updateCandidates(Candidates candidates) {
        return candidatesRepository.save(candidates);
    }
    /*@Transactional
    public Candidates updateCandidates(Long candidatesId, Candidates candidates) {

        Candidates emp = candidatesRepository.findById(candidatesId)
                .orElseThrow(() -> new IllegalStateException(
                        "Candidates with id " + candidatesId + " does not exist"
                ));
        return candidatesRepository.save(candidates);
    }*/

    /**
     * deletes' a Candidates
     * @param candidatesId
     */
    public void deleteCandidates(Long candidatesId) {
        candidatesRepository.deleteById(candidatesId);
    }


    /**
     *
     * @param id
     * @return
     */
    public Candidates findCandidatesById(Long id) {
        return candidatesRepository.findCandidatesById(id)
                .orElseThrow(
                        () -> new UserNotFoundException(
                                "User by id " + id + " was not found"
                        )
                );
    }




}
