package com.example.jobagapi.resource;

import java.time.LocalDate;

public class PostulantJobResource {
    private Long id;
    private boolean aceppt;

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

    public Long getIdPostulant() {
        return idPostulant;
    }

    public PostulantJobResource setIdPostulant(Long idPostulant) {
        this.idPostulant = idPostulant;
        return this;
    }

    public String getFirstnamePostulant() {
        return firstnamePostulant;
    }

    public PostulantJobResource setFirstnamePostulant(String firstnamePostulant) {
        this.firstnamePostulant = firstnamePostulant;
        return this;
    }

    public String getLastnamePostulant() {
        return lastnamePostulant;
    }

    public PostulantJobResource setLastnamePostulant(String lastnamePostulant) {
        this.lastnamePostulant = lastnamePostulant;
        return this;
    }

    public String getEmailPostulant() {
        return emailPostulant;
    }

    public PostulantJobResource setEmailPostulant(String emailPostulant) {
        this.emailPostulant = emailPostulant;
        return this;
    }

    public Long getNumberPostulant() {
        return numberPostulant;
    }

    public PostulantJobResource setNumberPostulant(Long numberPostulant) {
        this.numberPostulant = numberPostulant;
        return this;
    }

    public String getPasswordPostulant() {
        return passwordPostulant;
    }

    public PostulantJobResource setPasswordPostulant(String passwordPostulant) {
        this.passwordPostulant = passwordPostulant;
        return this;
    }

    public String getDocumentPostulant() {
        return documentPostulant;
    }

    public PostulantJobResource setDocumentPostulant(String documentPostulant) {
        this.documentPostulant = documentPostulant;
        return this;
    }

    public Long getIdJobOffer() {
        return idJobOffer;
    }

    public PostulantJobResource setIdJobOffer(Long idJobOffer) {
        this.idJobOffer = idJobOffer;
        return this;
    }

    public String getTypeJobOffer() {
        return typeJobOffer;
    }

    public PostulantJobResource setTypeJobOffer(String typeJobOffer) {
        this.typeJobOffer = typeJobOffer;
        return this;
    }

    public String getTitleJobOffer() {
        return titleJobOffer;
    }

    public PostulantJobResource setTitleJobOffer(String titleJobOffer) {
        this.titleJobOffer = titleJobOffer;
        return this;
    }

    public String getDescriptionJobOffer() {
        return descriptionJobOffer;
    }

    public PostulantJobResource setDescriptionJobOffer(String descriptionJobOffer) {
        this.descriptionJobOffer = descriptionJobOffer;
        return this;
    }

    public LocalDate getBegin_date_offerJobOffer() {
        return begin_date_offerJobOffer;
    }

    public PostulantJobResource setBegin_date_offerJobOffer(LocalDate begin_date_offerJobOffer) {
        this.begin_date_offerJobOffer = begin_date_offerJobOffer;
        return this;
    }

    public LocalDate getFinal_date_offerJobOffer() {
        return final_date_offerJobOffer;
    }

    public PostulantJobResource setFinal_date_offerJobOffer(LocalDate final_date_offerJobOffer) {
        this.final_date_offerJobOffer = final_date_offerJobOffer;
        return this;
    }

    public Long getSalaryJobOffer() {
        return salaryJobOffer;
    }

    public PostulantJobResource setSalaryJobOffer(Long salaryJobOffer) {
        this.salaryJobOffer = salaryJobOffer;
        return this;
    }

    public String getDirectionJobOffer() {
        return directionJobOffer;
    }

    public PostulantJobResource setDirectionJobOffer(String directionJobOffer) {
        this.directionJobOffer = directionJobOffer;
        return this;
    }
}

