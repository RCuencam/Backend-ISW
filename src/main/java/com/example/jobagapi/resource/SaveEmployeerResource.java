package com.example.jobagapi.resource;

import javax.validation.constraints.NotNull;

public class SaveEmployeerResource extends SaveUserResource{
    @NotNull
    public String posicion;



    public String getPosicion() {
        return posicion;
    }

    public SaveEmployeerResource setPosicion(String posicion) {
        this.posicion = posicion;
        return this;
    }

    public SaveEmployeerResource(){
        super();
    }

    public SaveEmployeerResource(@NotNull String firstname, @NotNull String lastname, @NotNull String email, @NotNull Long number, @NotNull String password, String document, String posicion) {
        super(firstname, lastname, email, number, password, document);
        this.posicion = posicion;

    }
}
