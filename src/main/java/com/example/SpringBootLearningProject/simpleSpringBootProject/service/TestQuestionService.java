package com.example.SpringBootLearningProject.simpleSpringBootProject.service;

import com.example.SpringBootLearningProject.simpleSpringBootProject.exception.UserNotFoundException;
import com.example.SpringBootLearningProject.simpleSpringBootProject.model.qcm.TestQuestion;
import com.example.SpringBootLearningProject.simpleSpringBootProject.repository.TestQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestQuestionService {

        private final TestQuestionRepository testQuestionRepository;


        @Autowired
        public TestQuestionService(TestQuestionRepository testQuestionRepository) {
            this.testQuestionRepository = testQuestionRepository;
        }

        /**
         *  creates new employee
         * @param testQuestion
         */
        public TestQuestion addNewTestQuestion(TestQuestion testQuestion) {
            return testQuestionRepository.save(testQuestion);
        }

        /**
         *
         * @return all Employees
         */
        public List<TestQuestion> getTestQuestions() {

            return testQuestionRepository.findAll();
        }


        /**
         *
         * @param testQuestion
         * @return
         */
        public TestQuestion updateTestQuestion(TestQuestion testQuestion) {
            return testQuestionRepository.save(testQuestion);
        }
    /*@Transactional
    public TestQuestion updateTestQuestion(Long testQuestionId, TestQuestion testQuestion) {

        TestQuestion tqs = testQuestionRepository.findById(testQuestionId)
                .orElseThrow(() -> new IllegalStateException(
                        "testQuestion with id " + testQuestionId + " does not exist"
                ));
        return testQuestionRepository.save(testQuestion);
    }*/

        /**
         * deletes' a employee
         * @param testQuestionId
         */
        public void deleteTestQuestion(Long testQuestionId) {
            testQuestionRepository.deleteById(testQuestionId);
        }


        /**
         *
         * @param id
         * @return
         */
        public TestQuestion findTestQuestionById(Long id) {
            return testQuestionRepository.findTestQuestionById(id)
                    .orElseThrow(
                            () -> new UserNotFoundException(
                                    "TestQuestion by id " + id + " was not found"
                            )
                    );
        }

}
