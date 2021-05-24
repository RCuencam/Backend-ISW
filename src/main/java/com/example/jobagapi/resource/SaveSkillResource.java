package com.example.jobagapi.resource;

import javax.validation.constraints.NotNull;

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
