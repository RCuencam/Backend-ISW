package com.example.jobagapi.domain.model;

import javax.persistence.*;

@Entity
@Table(name ="sectors")
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;
    private String description;


    public Long getId() {
        return id;
    }

    public Sector setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Sector setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Sector setDescription(String description) {
        this.description = description;
        return this;
    }
}
