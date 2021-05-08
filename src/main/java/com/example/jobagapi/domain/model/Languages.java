package com.example.jobagapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "languages")
public class Languages extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Long level;

    public Long getId() {
        return id;
    }

    //Relacion
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "languages_id", referencedColumnName = "id", nullable = false)
    private ProfessionalProfile professionalProfile;

    public Languages setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Languages setName(String name) {
        this.name = name;
        return this;
    }

    public Long getLevel() {
        return level;
    }

    public Languages setLevel(Long level) {
        this.level = level;
        return this;
    }
}
