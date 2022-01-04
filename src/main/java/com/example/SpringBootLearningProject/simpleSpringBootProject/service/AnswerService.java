package com.example.SpringBootLearningProject.simpleSpringBootProject.service;

import com.example.SpringBootLearningProject.simpleSpringBootProject.exception.UserNotFoundException;
import com.example.SpringBootLearningProject.simpleSpringBootProject.model.qcm.Answer;
import com.example.SpringBootLearningProject.simpleSpringBootProject.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnswerService {

    private final AnswerRepository answerRepository;


    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    /**
     *  creates new employee
     * @param answer
     */
    public Answer addNewAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    /**
     *
     * @return all Employees
     */
    public List<Answer> getAnswers() {

        return answerRepository.findAll();
    }


    /**
     *
     * @param answer
     * @return
     */
    public Answer updateAnswer(Answer answer) {
        return answerRepository.save(answer);
    }
    /*@Transactional
    public Answer updateAnswer(Long answerId, Answer answer) {

        Answer tqs = answerRepository.findById(answerId)
                .orElseThrow(() -> new IllegalStateException(
                        "Answer with id " + answerId + " does not exist"
                ));
        return answerRepository.save(Answer);
    }*/

    /**
     * deletes' a employee
     * @param answerId
     */
    public void deleteAnswer(Long answerId) {
        answerRepository.deleteById(answerId);
    }


    /**
     *
     * @param id
     * @return
     */
    public Answer findAnswerById(Long id) {
        return answerRepository.findAnswerById(id)
                .orElseThrow(
                        () -> new UserNotFoundException(
                                "Answer by id " + id + " was not found"
                        )
                );
    }

}
