package com.example.jobagapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "studies")
public class Studies extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Long degree;

    //Relación
    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
    //@JoinColumn(name = "studies_id", nullable = false)
    //@JsonIgnore
    //private ProfessionalProfile professionalProfile;

    public Long getId() {
        return id;
    }

    public Studies setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Studies setName(String name) {
        this.name = name;
        return this;
    }

    public Long getDegree() {
        return degree;
    }

    public Studies setDegree(Long degree) {
        this.degree = degree;
        return this;
    }
}
