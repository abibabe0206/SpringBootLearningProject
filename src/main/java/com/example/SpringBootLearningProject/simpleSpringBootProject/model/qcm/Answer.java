package com.example.SpringBootLearningProject.simpleSpringBootProject.model.qcm;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Answer implements Serializable {

    @Id
    @SequenceGenerator(
            name = "answer_sequence",
            sequenceName = "answer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "answer_sequence"
    )
    @Column(nullable = false, updatable = false)
    private Long id;
    private String response;
    private boolean isCorrect;


    public Answer() {}

    public Answer(Long id, String response, boolean isCorrect) {
        this.id = id;
        this.response = response;
        this.isCorrect = isCorrect;
    }

    public Answer(String response, boolean isCorrect) {
        this.response = response;
        this.isCorrect = isCorrect;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(boolean correct) {
        isCorrect = correct;
    }


    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", response='" + response + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
