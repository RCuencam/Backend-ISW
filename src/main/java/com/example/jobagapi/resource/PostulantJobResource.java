package com.example.jobagapi.resource;

public class PostulantJobResource {
    private Long id;
    private boolean aceppt;

    private Long jobOfferId;
    private String titleJobOffer;
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

    public boolean isAceppt() {
        return aceppt;
    }

    public PostulantJobResource setAceppt(boolean aceppt) {
        this.aceppt = aceppt;
        return this;
    }

    public Long getJobOfferId() {
        return jobOfferId;
    }

    public PostulantJobResource setJobOfferId(Long jobOfferId) {
        this.jobOfferId = jobOfferId;
        return this;
    }

    public String getTitleJobOffer() {
        return titleJobOffer;
    }

    public PostulantJobResource setTitleJobOffer(String titleJobOffer) {
        this.titleJobOffer = titleJobOffer;
        return this;
    }

    public Long getPostulantId() {
        return postulantId;
    }

    public PostulantJobResource setPostulantId(Long postulantId) {
        this.postulantId = postulantId;
        return this;
    }

    public String getFirstNamePostulant() {
        return firstNamePostulant;
    }

    public PostulantJobResource setFirstNamePostulant(String firstNamePostulant) {
        this.firstNamePostulant = firstNamePostulant;
        return this;
    }

    public String getLastNamePostulant() {
        return lastNamePostulant;
    }

    public PostulantJobResource setLastNamePostulant(String lastNamePostulant) {
        this.lastNamePostulant = lastNamePostulant;
        return this;
    }

    public String getEmailPostulant() {
        return emailPostulant;
    }

    public PostulantJobResource setEmailPostulant(String emailPostulant) {
        this.emailPostulant = emailPostulant;
        return this;
    }
}
