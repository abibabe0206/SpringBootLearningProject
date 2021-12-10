package com.example.SpringBootLearningProject.simpleSpringBootProject.controller;


import com.example.SpringBootLearningProject.simpleSpringBootProject.model.qcm.TestQuestion;
import com.example.SpringBootLearningProject.simpleSpringBootProject.service.TestQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/v1/testQuestion")
public class TestQuestionController {

    private final TestQuestionService testQuestionService;


    @Autowired
    public TestQuestionController(TestQuestionService testQuestionService) {
        this.testQuestionService = testQuestionService;
    }

    @GetMapping
    public ResponseEntity<List<TestQuestion>> getEmployees() {
        List<TestQuestion> testQuestionList = testQuestionService.getTestQuestions();
        return new ResponseEntity<>(testQuestionList, HttpStatus.OK);
    }

    @GetMapping("/{testQuestionId}")
    public ResponseEntity<TestQuestion> getTestQuestionById(@PathVariable("testQuestionId") Long testQuestionId) {
        TestQuestion testQuestion = testQuestionService.findTestQuestionById(testQuestionId);
        return new ResponseEntity<>(testQuestion, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TestQuestion> registerNewTestQuestion(@RequestBody TestQuestion testQuestion) {
        TestQuestion newTestQuestion = testQuestionService.addNewTestQuestion(testQuestion);
        return new ResponseEntity<>(newTestQuestion, HttpStatus.CREATED);
    }


    @PutMapping("/update/{testQuestionId}")
    public ResponseEntity<TestQuestion> updateTestQuestion(
            @PathVariable("testQuestionId") Long testQuestionId,
            @RequestBody TestQuestion testQuestion)  throws IllegalStateException {

        TestQuestion qcm = testQuestionService.findTestQuestionById(testQuestionId);


        qcm.setLabel(testQuestion.getLabel());
        final TestQuestion updatedTestQuestion = testQuestionService.updateTestQuestion(qcm);
        return ResponseEntity.ok(updatedTestQuestion);
    }


    @DeleteMapping("/{testQuestionId}")
    public ResponseEntity<?> deleteTestQuestion(@PathVariable("testQuestionId") Long testQuestionId) {
        testQuestionService.deleteTestQuestion(testQuestionId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
