package com.example.SpringBootLearningProject.simpleSpringBootProject.model.qcm;


import lombok.Data;

import java.util.Date;

@Data
public class SearchParametersDTO {

    private String nom;
    private String categories;
    private Date date;

    public SearchParametersDTO(String nom, String categories, Date date) {
        this.nom = nom;
        this.categories = categories;
        this.date = date;
    }
}
