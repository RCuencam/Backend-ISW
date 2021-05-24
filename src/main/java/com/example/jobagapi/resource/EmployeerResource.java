package com.example.jobagapi.resource;

import com.example.jobagapi.domain.model.AuditModel;

import javax.validation.constraints.NotNull;

public class EmployeerResource extends UserResource {


    public String posicion;

    public String getPosicion() {
        return posicion;
    }

    public EmployeerResource setPosicion(String posicion) {
        this.posicion = posicion;
        return this;
    }

    public EmployeerResource(){
        super();
    }

    public EmployeerResource(Long id, @NotNull String firstname, @NotNull String lastname, @NotNull String email, @NotNull Long number, @NotNull String password, String document, String posicion) {
        super(id, firstname, lastname, email, number, password, document);
        this.posicion = posicion;

    }

}
