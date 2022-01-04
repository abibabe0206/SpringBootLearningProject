package com.example.SpringBootLearningProject.simpleSpringBootProject.controller;

import com.example.SpringBootLearningProject.simpleSpringBootProject.model.qcm.Answer;
import com.example.SpringBootLearningProject.simpleSpringBootProject.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/v1/testQuestion/answer")
public class AnswerController {

    private final AnswerService answerService;


    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping
    public ResponseEntity<List<Answer>> getAnswers() {
        List<Answer> answerList = answerService.getAnswers();
        return new ResponseEntity<>(answerList, HttpStatus.OK);
    }

    @GetMapping("/{answerId}")
    public ResponseEntity<Answer> getAnswerById(@PathVariable("answerId") Long answerId) {
        Answer answer = answerService.findAnswerById(answerId);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Answer> registerNewAnswer(@RequestBody Answer answer) {
        Answer newAnswer = answerService.addNewAnswer(answer);
        return new ResponseEntity<>(newAnswer, HttpStatus.CREATED);
    }


    @PutMapping("/update/{answerId}")
    public ResponseEntity<Answer> updateAnswer(
            @PathVariable("answerId") Long answerId,
            @RequestBody Answer answer)  throws IllegalStateException {

        Answer ans = answerService.findAnswerById(answerId);


        ans.setResponse(answer.getResponse());
        ans.setIsCorrect(answer.isCorrect());
        final Answer updatedAnswer = answerService.updateAnswer(ans);
        return ResponseEntity.ok(updatedAnswer);
    }


    @DeleteMapping("/{answerId}")
    public ResponseEntity<?> deleteAnswer(@PathVariable("answerId") Long answerId) {
        answerService.deleteAnswer(answerId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}

