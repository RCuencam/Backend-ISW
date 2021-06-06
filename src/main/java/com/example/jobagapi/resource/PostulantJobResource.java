package com.example.jobagapi.resource;

public class PostulantJobResource {
    private Long id;
    private boolean aceppt;

    public Long getId() {
        return id;
    }

    public PostulantJobResource setId(Long id) {
        this.id = id;
        return this;
    }

    public boolean isAceppt() {
        return aceppt;
    }

    public PostulantJobResource setAceppt(boolean aceppt) {
        this.aceppt = aceppt;
        return this;
    }
}
