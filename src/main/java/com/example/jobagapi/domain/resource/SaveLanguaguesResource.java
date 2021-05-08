package com.example.jobagapi.domain.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SaveLanguaguesResource {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Long level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public SaveLanguaguesResource setName(String name) {
        this.name = name;
        return this;
    }

    public Long getLevel() {
        return level;
    }

    public SaveLanguaguesResource setLevel(Long level) {
        this.level = level;
        return this;
    }
}
