package com.example.jobagapi.resource;

public class CompanyResource {

    private Long id;
    private String name;
    private String description;
    private String logo;
    private Long ruc;
    private String direccion;

    //Employeer
    private Long idEmployeer;
    private String firstnameEmployeer;
    private String lastnameEmployeer;
    private String emailEmployeer;
    private Long numberEmployeer;
    private String passwordEmployeer;
    private String documentEmployeer;

    //Sector

    private Long idSector;
    private String nameSector;
    private String descriptionSector;

    public Long getId() {
        return id;
    }

    public CompanyResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CompanyResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CompanyResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getLogo() {
        return logo;
    }

    public CompanyResource setLogo(String logo) {
        this.logo = logo;
        return this;
    }

    public Long getRuc() {
        return ruc;
    }

    public CompanyResource setRuc(Long ruc) {
        this.ruc = ruc;
        return this;
    }

    public String getDireccion() {
        return direccion;
    }

    public CompanyResource setDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public Long getIdEmployeer() {
        return idEmployeer;
    }

    public CompanyResource setIdEmployeer(Long idEmployeer) {
        this.idEmployeer = idEmployeer;
        return this;
    }

    public String getFirstnameEmployeer() {
        return firstnameEmployeer;
    }

    public CompanyResource setFirstnameEmployeer(String firstnameEmployeer) {
        this.firstnameEmployeer = firstnameEmployeer;
        return this;
    }

    public String getLastnameEmployeer() {
        return lastnameEmployeer;
    }

    public CompanyResource setLastnameEmployeer(String lastnameEmployeer) {
        this.lastnameEmployeer = lastnameEmployeer;
        return this;
    }

    public String getEmailEmployeer() {
        return emailEmployeer;
    }

    public CompanyResource setEmailEmployeer(String emailEmployeer) {
        this.emailEmployeer = emailEmployeer;
        return this;
    }

    public Long getNumberEmployeer() {
        return numberEmployeer;
    }

    public CompanyResource setNumberEmployeer(Long numberEmployeer) {
        this.numberEmployeer = numberEmployeer;
        return this;
    }

    public String getPasswordEmployeer() {
        return passwordEmployeer;
    }

    public CompanyResource setPasswordEmployeer(String passwordEmployeer) {
        this.passwordEmployeer = passwordEmployeer;
        return this;
    }

    public String getDocumentEmployeer() {
        return documentEmployeer;
    }

    public CompanyResource setDocumentEmployeer(String documentEmployeer) {
        this.documentEmployeer = documentEmployeer;
        return this;
    }

    public Long getIdSector() {
        return idSector;
    }

    public CompanyResource setIdSector(Long idSector) {
        this.idSector = idSector;
        return this;
    }

    public String getNameSector() {
        return nameSector;
    }

    public CompanyResource setNameSector(String nameSector) {
        this.nameSector = nameSector;
        return this;
    }

    public String getDescriptionSector() {
        return descriptionSector;
    }

    public CompanyResource setDescriptionSector(String descriptionSector) {
        this.descriptionSector = descriptionSector;
        return this;
    }
}
