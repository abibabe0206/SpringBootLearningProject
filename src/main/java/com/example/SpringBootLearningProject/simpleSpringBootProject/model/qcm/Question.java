package com.example.SpringBootLearningProject.simpleSpringBootProject.model.qcm;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Question implements Serializable {


    @Id
    @SequenceGenerator(
            name = "question_sequence",
            sequenceName = "question_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "question_sequence"
    )
    @Column(nullable = false, updatable = false)
    private Long id;
    private String questionBody;

    @OneToMany
    @JoinColumn(name = "answer", nullable = false)
    private List<Answer> answer;


    public Question() {}

    public Question(Long id, String questionBody, List<Answer> answer) {
        this.id = id;
        this.questionBody = questionBody;
        this.answer = answer;
    }

    public Question(String questionBody, List<Answer> answer) {
        this.questionBody = questionBody;
        this.answer = answer;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionBody() {
        return questionBody;
    }

    public void setQuestionBody(String questionBody) {
        this.questionBody = questionBody;
    }

    public List<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionBody='" + questionBody + '\'' +
                ", answer=" + answer +
                '}';
    }
}
