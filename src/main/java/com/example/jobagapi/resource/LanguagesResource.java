package com.example.jobagapi.resource;

public class LanguagesResource {
    private Long id;
    private String name;
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

    public LanguagesResource setName(String name) {
        this.name = name;
        return this;
    }

    public Long getLevel() {
        return level;
    }

    public LanguagesResource setLevel(Long level) {
        this.level = level;
        return this;
    }
}
