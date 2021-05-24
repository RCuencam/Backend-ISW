package com.example.jobagapi.resource;

import javax.validation.constraints.NotNull;

public class SaveLanguaguesResource {
    @NotNull
    private String name;
    @NotNull
    private Long level;

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
