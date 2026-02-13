package com.esprit.microservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    /**
     * "oui" = disponible, "non" = occupé
     */
    @Column(length = 10)
    private String etat = "oui";

    public Job() {
    }

    public Job(String name, String etat) {
        this.name = name;
        this.etat = etat != null ? etat : "oui";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
