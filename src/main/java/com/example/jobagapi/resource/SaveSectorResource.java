package com.example.jobagapi.resource;

public class SaveSectorResource {


    private String name;
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
