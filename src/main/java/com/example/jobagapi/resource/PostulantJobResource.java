package com.example.jobagapi.resource;

public class PostulantJobResource {
    private Long id;
    private boolean accept;
    private Long postulantId;
    private String firstNamePostulant;
    private String lastNamePostulant;
    private String emailPostulant;

    public Long getId() {
        return id;
    }

    public PostulantJobResource setId(Long id) {
        this.id = id;
        return this;
    }

    public boolean isAccept() {
        return accept;
    }

    public PostulantJobResource setAccept(boolean accept) {
        this.accept = accept;
        return this;
    }

    public Long getPostulantId() {
        return postulantId;
    }

    public void setPostulantId(Long postulantId) {
        this.postulantId = postulantId;
    }

    public String getFirstNamePostulant() {
        return firstNamePostulant;
    }

    public void setFirstNamePostulant(String firstNamePostulant) {
        this.firstNamePostulant = firstNamePostulant;
    }

    public String getLastNamePostulant() {
        return lastNamePostulant;
    }

    public void setLastNamePostulant(String lastNamePostulant) {
        this.lastNamePostulant = lastNamePostulant;
    }

    public String getEmailPostulant() {
        return emailPostulant;
    }

    public void setEmailPostulant(String emailPostulant) {
        this.emailPostulant = emailPostulant;
    }
}

