package com.example.jobagapi.resource;

import javax.validation.constraints.Size;

public class SaveCompanyResource {

    @Size(max = 100)
    private String name;

    @Size(max = 100)
    private String description;

    @Size(max = 100)
    private String logo;

    private Long ruc;

    @Size(max = 100)
    private String direccion;


    public String getName() {
        return name;
    }

    public SaveCompanyResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SaveCompanyResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getLogo() {
        return logo;
    }

    public SaveCompanyResource setLogo(String logo) {
        this.logo = logo;
        return this;
    }

    public Long getRuc() {
        return ruc;
    }

    public SaveCompanyResource setRuc(Long ruc) {
        this.ruc = ruc;
        return this;
    }

    public String getDireccion() {
        return direccion;
    }

    public SaveCompanyResource setDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }
}
