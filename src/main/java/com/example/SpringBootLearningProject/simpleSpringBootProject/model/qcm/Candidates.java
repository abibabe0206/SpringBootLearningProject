package com.example.SpringBootLearningProject.simpleSpringBootProject.model.qcm;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class Candidates implements Serializable {


    @Id
    @SequenceGenerator(
            name = "candidate_sequence",
            sequenceName = "candidate_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "candidate_sequence"
    )
    @Column(nullable = false, updatable = false)
    private Long id;
    private Date date;
    private String nom;
    private String prenom;
    private String categories;


    public Candidates() {}

    public Candidates(Long id, Date date,
                      String nom, String prenom,
                      String categories) {
        this.id = id;
        this.date = date;
        this.nom = nom;
        this.prenom = prenom;
        this.categories = categories;
    }


    public Candidates(Date date, String nom,
                      String prenom, String categories) {
        this.date = date;
        this.nom = nom;
        this.prenom = prenom;
        this.categories = categories;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Candidates{" +
                "id=" + id +
                ", date=" + date +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", categories='" + categories + '\'' +
                '}';
    }
}
