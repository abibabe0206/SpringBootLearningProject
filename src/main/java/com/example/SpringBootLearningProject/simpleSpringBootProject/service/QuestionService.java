package com.example.SpringBootLearningProject.simpleSpringBootProject.service;

import com.example.SpringBootLearningProject.simpleSpringBootProject.exception.UserNotFoundException;
import com.example.SpringBootLearningProject.simpleSpringBootProject.model.qcm.Question;
import com.example.SpringBootLearningProject.simpleSpringBootProject.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QuestionService {

    private final QuestionRepository questionRepository;


    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    /**
     *  creates new employee
     * @param question
     */
    public Question addNewQuestion(Question question) {
        return questionRepository.save(question);
    }

    /**
     *
     * @return all Employees
     */
    public List<Question> getQuestions() {

        return questionRepository.findAll();
    }


    /**
     *
     * @param question
     * @return
     */
    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }
    /*@Transactional
    public Question updateQuestion(Long questionId, Question question) {

        Question tqs = questionRepository.findById(questionId)
                .orElseThrow(() -> new IllegalStateException(
                        "Question with id " + questionId + " does not exist"
                ));
        return questionRepository.save(Question);
    }*/

    /**
     * deletes' a employee
     * @param questionId
     */
    public void deleteQuestion(Long questionId) {
        questionRepository.deleteById(questionId);
    }


    /**
     *
     * @param id
     * @return
     */
    public Question findQuestionById(Long id) {
        return questionRepository.findQuestionById(id)
                .orElseThrow(
                        () -> new UserNotFoundException(
                                "Question by id " + id + " was not found"
                        )
                );
    }

}
