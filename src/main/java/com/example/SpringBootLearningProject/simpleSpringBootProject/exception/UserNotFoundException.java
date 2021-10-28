package com.example.SpringBootLearningProject.simpleSpringBootProject.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
