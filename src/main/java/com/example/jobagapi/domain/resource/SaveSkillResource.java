package com.example.jobagapi.domain.resource;

import com.example.jobagapi.domain.model.ProfessionalProfile;
import com.example.jobagapi.domain.model.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;
import com.example.jobagapi.domain.model.Skill;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

public class SaveSkillResource {
    @NotNull
    private String name;
    @NotNull
    private String description;

    public String getName() {
        return name;
    }

    public SaveSkillResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SaveSkillResource setDescription(String description) {
        this.description = description;
        return this;
    }

}
