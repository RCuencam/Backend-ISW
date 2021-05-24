package com.example.jobagapi.resource;

import com.sun.istack.NotNull;

public class SaveStudiesResource {
    @NotNull
    private String name;
    @NotNull
    private Long degree;

    public String getName() {
        return name;
    }

    public SaveStudiesResource setName(String name) {
        this.name = name;
        return this;
    }

    public Long getDegree() {
        return degree;
    }

    public SaveStudiesResource setDegree(Long degree) {
        this.degree = degree;
        return this;
    }
}
