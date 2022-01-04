package com.example.SpringBootLearningProject.simpleSpringBootProject.controller;

import com.example.SpringBootLearningProject.simpleSpringBootProject.model.qcm.Question;
import com.example.SpringBootLearningProject.simpleSpringBootProject.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/v1/testQuestion/question")
public class QuestionController  {

    private final QuestionService questionService;


    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public ResponseEntity<List<Question>> getQuestions() {
        List<Question> questionList = questionService.getQuestions();
        return new ResponseEntity<>(questionList, HttpStatus.OK);
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<Question> getQuestionById(@PathVariable("questionId") Long questionId) {
        Question question = questionService.findQuestionById(questionId);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Question> registerNewQuestion(@RequestBody Question question) {
        Question newQuestion = questionService.addNewQuestion(question);
        return new ResponseEntity<>(newQuestion, HttpStatus.CREATED);
    }


    @PutMapping("/update/{questionId}")
    public ResponseEntity<Question> updateQuestion(
            @PathVariable("questionId") Long questionId,
            @RequestBody Question question)  throws IllegalStateException {

        Question ques = questionService.findQuestionById(questionId);


        ques.setQuestionBody(question.getQuestionBody());
        ques.setAnswer(question.getAnswer());
        final Question updatedQuestion = questionService.updateQuestion(ques);
        return ResponseEntity.ok(updatedQuestion);
    }


    @DeleteMapping("/{questionId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable("questionId") Long questionId) {
        questionService.deleteQuestion(questionId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}

