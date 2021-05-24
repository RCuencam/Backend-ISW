package com.example.jobagapi.resource;

import com.sun.istack.NotNull;

public class SaveSectorResource {
    @NotNull
    private String name;
    @NotNull
    private String description;

    public String getName() {
        return name;
    }

    public SaveSectorResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SaveSectorResource setDescription(String description) {
        this.description = description;
        return this;
    }
}
