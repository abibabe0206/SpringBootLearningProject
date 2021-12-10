package com.example.SpringBootLearningProject.simpleSpringBootProject.model.qcm;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class TestQuestion implements Serializable {

    @Id
    @SequenceGenerator(
            name = "testquestion_sequence",
            sequenceName = "testquestion_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "testquestion_sequence"
    )
    @Column(nullable = false, updatable = false)
    private Long id;
    private String label;

    public TestQuestion() {}

    public TestQuestion(Long id, String label) {
        this.id = id;
        this.label = label;
    }

    public TestQuestion(String label) {
        this.label = label;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "TestQuestion{" +
                "id=" + id +
                ", label='" + label + '\'' +
                '}';
    }
}
