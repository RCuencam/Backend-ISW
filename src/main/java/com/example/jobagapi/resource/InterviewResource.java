package com.example.jobagapi.resource;

import java.time.LocalDate;

public class InterviewResource {
    private Long id;
    private LocalDate date_Interview;
    private LocalDate final_date_Interview;
    private String link_Interview;
    private Long jobOfferId;
    private String titleJobOffer;
    private String descriptionJobOffer;
    private Long postulantId;
    private String firstNamePostulant;
    private String lastNamePostulant;
    private String emailPostulant;

    public Long getId() {
        return id;
    }

    public InterviewResource setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDate getDate_Interview() {
        return date_Interview;
    }

    public InterviewResource setDate_Interview(LocalDate date_Interview) {
        this.date_Interview = date_Interview;
        return this;
    }

    public LocalDate getFinal_date_Interview() {
        return final_date_Interview;
    }

    public InterviewResource setFinal_date_Interview(LocalDate final_date_Interview) {
        this.final_date_Interview = final_date_Interview;
        return this;
    }

    public String getLink_Interview() {
        return link_Interview;
    }

    public InterviewResource setLink_Interview(String link_Interview) {
        this.link_Interview = link_Interview;
        return this;
    }

    public Long getJobOfferId() {
        return jobOfferId;
    }

    public InterviewResource setJobOfferId(Long jobOfferId) {
        this.jobOfferId = jobOfferId;
        return this;
    }

    public String getFirstNamePostulant() {
        return firstNamePostulant;
    }

    public InterviewResource setFirstNamePostulant(String firstNamePostulant) {
        this.firstNamePostulant = firstNamePostulant;
        return this;
    }

    public String getTitleJobOffer() {
        return titleJobOffer;
    }

    public InterviewResource setTitleJobOffer(String titleJobOffer) {
        this.titleJobOffer = titleJobOffer;
        return this;
    }

    public String getDescriptionJobOffer() {
        return descriptionJobOffer;
    }

    public InterviewResource setDescriptionJobOffer(String descriptionJobOffer) {
        this.descriptionJobOffer = descriptionJobOffer;
        return this;
    }

    public Long getPostulantId() {
        return postulantId;
    }

    public InterviewResource setPostulantId(Long postulantId) {
        this.postulantId = postulantId;
        return this;
    }

    public String getLasttNamePostulant() {
        return lastNamePostulant;
    }

    public InterviewResource setLasttNamePostulant(String lasttNamePostulant) {
        this.lastNamePostulant = lasttNamePostulant;
        return this;
    }

    public String getLastNamePostulant() {
        return lastNamePostulant;
    }

    public InterviewResource setLastNamePostulant(String lastNamePostulant) {
        this.lastNamePostulant = lastNamePostulant;
        return this;
    }

    public String getEmailPostulant() {
        return emailPostulant;
    }

    public InterviewResource setEmailPostulant(String emailPostulant) {
        this.emailPostulant = emailPostulant;
        return this;
    }
}
