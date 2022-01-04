package com.example.SpringBootLearningProject.simpleSpringBootProject.controller;


import com.example.SpringBootLearningProject.simpleSpringBootProject.model.qcm.Candidates;
import com.example.SpringBootLearningProject.simpleSpringBootProject.model.qcm.SearchParametersDTO;
import com.example.SpringBootLearningProject.simpleSpringBootProject.service.CandidatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/v1/testQuestion/candidate")
public class CandidatesController {

    private final CandidatesService candidatesService;


    @Autowired
    public CandidatesController(CandidatesService candidatesService) {
        this.candidatesService = candidatesService;
    }

    @GetMapping
    public ResponseEntity<List<Candidates>> getCandidates() {
        List<Candidates> candidatesList = candidatesService.getCandidates();
        return new ResponseEntity<>(candidatesList, HttpStatus.OK);
    }

    @GetMapping("/{candidatesId}")
    public ResponseEntity<Candidates> getCandidatesById(@PathVariable("candidatesId") Long candidatesId) {
        Candidates candidates = candidatesService.findCandidatesById(candidatesId);
        return new ResponseEntity<>(candidates, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Candidates> registerNewCandidates(@RequestBody Candidates candidates) {
        Candidates newCandidates = candidatesService.addNewCandidates(candidates);
        return new ResponseEntity<>(newCandidates, HttpStatus.CREATED);
    }


    @PutMapping("/update/{candidatesId}")
    public ResponseEntity<Candidates> updateCandidates(
            @PathVariable("candidatesId") Long candidatesId,
            @RequestBody Candidates candidates)  throws IllegalStateException {

        Candidates can = candidatesService.findCandidatesById(candidatesId);


        can.setDate(candidates.getDate());
        can.setNom(candidates.getNom());
        can.setPrenom(candidates.getPrenom());
        can.setCategories(candidates.getCategories());
        final Candidates updatedCandidates = candidatesService.updateCandidates(can);
        return ResponseEntity.ok(updatedCandidates);
    }


    @DeleteMapping("/{candidatesId}")
    public ResponseEntity<?> deleteCandidates(@PathVariable("candidatesId") Long candidatesId) {
        candidatesService.deleteCandidates(candidatesId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    /**
     *
     * @param nom ou prenom de l'employe
     * @param categories   nom d'un client ou d'un projet
     * @param date
     * @return
     */
    @GetMapping("/search")
    public ResponseEntity<List<Candidates>> searchCandidate(@RequestParam(value = "nom", required = false) String nom, @RequestParam(
            value = "categories", required = false) String categories, @RequestParam(value = "date",required = false) Date date) {
        return ResponseEntity.ok().body(candidatesService.findCandidatesByFilter(new SearchParametersDTO(nom, categories, date)));
    }

}
