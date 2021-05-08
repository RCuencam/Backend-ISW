package com.example.jobagapi.domain.resource;

import com.example.jobagapi.domain.model.AuditModel;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class SkillResource extends AuditModel {
    public Long id;
    private String name;
    private String description;

    public Long getId(){return id;}

    public SkillResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName(){return name;}

    public SkillResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SkillResource setDescripcion(String name) {
        this.description = description;
        return this;
    }

}
