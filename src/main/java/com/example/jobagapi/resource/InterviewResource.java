package com.example.jobagapi.resource;

import java.time.LocalDate;

public class InterviewResource {

    private Long id;
    private LocalDate date_Interview;
    private LocalDate final_date_Interview;
    private String link_Interview;

    private Long idPostulant;
    private String firstnamePostulant;
    private String lastnamePostulant;
    private String emailPostulant;
    private Long numberPostulant;
    private String passwordPostulant;
    private String documentPostulant;

    private Long idJobOffer;
    private String typeJobOffer;
    private String titleJobOffer;
    private String descriptionJobOffer;
    private LocalDate begin_date_offerJobOffer;
    private LocalDate final_date_offerJobOffer;
    private Long salaryJobOffer;
    private String directionJobOffer;


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


    public Long getIdPostulant() {
        return idPostulant;
    }

    public InterviewResource setIdPostulant(Long idPostulant) {
        this.idPostulant = idPostulant;
        return this;
    }

    public String getFirstnamePostulant() {
        return firstnamePostulant;
    }

    public InterviewResource setFirstnamePostulant(String firstnamePostulant) {
        this.firstnamePostulant = firstnamePostulant;
        return this;
    }

    public String getLastnamePostulant() {
        return lastnamePostulant;
    }

    public InterviewResource setLastnamePostulant(String lastnamePostulant) {
        this.lastnamePostulant = lastnamePostulant;
        return this;
    }

    public String getEmailPostulant() {
        return emailPostulant;
    }

    public InterviewResource setEmailPostulant(String emailPostulant) {
        this.emailPostulant = emailPostulant;
        return this;
    }

    public Long getNumberPostulant() {
        return numberPostulant;
    }

    public InterviewResource setNumberPostulant(Long numberPostulant) {
        this.numberPostulant = numberPostulant;
        return this;
    }

    public String getPasswordPostulant() {
        return passwordPostulant;
    }

    public InterviewResource setPasswordPostulant(String passwordPostulant) {
        this.passwordPostulant = passwordPostulant;
        return this;
    }

    public String getDocumentPostulant() {
        return documentPostulant;
    }

    public InterviewResource setDocumentPostulant(String documentPostulant) {
        this.documentPostulant = documentPostulant;
        return this;
    }

    public Long getIdJobOffer() {
        return idJobOffer;
    }

    public InterviewResource setIdJobOffer(Long idJobOffer) {
        this.idJobOffer = idJobOffer;
        return this;
    }

    public String getTypeJobOffer() {
        return typeJobOffer;
    }

    public InterviewResource setTypeJobOffer(String typeJobOffer) {
        this.typeJobOffer = typeJobOffer;
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

    public LocalDate getBegin_date_offerJobOffer() {
        return begin_date_offerJobOffer;
    }

    public InterviewResource setBegin_date_offerJobOffer(LocalDate begin_date_offerJobOffer) {
        this.begin_date_offerJobOffer = begin_date_offerJobOffer;
        return this;
    }

    public LocalDate getFinal_date_offerJobOffer() {
        return final_date_offerJobOffer;
    }

    public InterviewResource setFinal_date_offerJobOffer(LocalDate final_date_offerJobOffer) {
        this.final_date_offerJobOffer = final_date_offerJobOffer;
        return this;
    }

    public Long getSalaryJobOffer() {
        return salaryJobOffer;
    }

    public InterviewResource setSalaryJobOffer(Long salaryJobOffer) {
        this.salaryJobOffer = salaryJobOffer;
        return this;
    }

    public String getDirectionJobOffer() {
        return directionJobOffer;
    }

    public InterviewResource setDirectionJobOffer(String directionJobOffer) {
        this.directionJobOffer = directionJobOffer;
        return this;
    }
}
