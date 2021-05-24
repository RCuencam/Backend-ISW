package com.example.jobagapi.resource;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class SavePostulantResource extends SaveUserResource{
    private String civil_status;

    public SavePostulantResource(){
        super();
    }

    public SavePostulantResource(@NotNull String firstname,  @NotNull String lastname,  @NotNull String email, @NotNull Long number, @NotNull String password, String document,String civil_status) {
        super(firstname, lastname, email, number, password, document);
        this.civil_status = civil_status;

    }
    public String getCivil_status() {
        return civil_status;
    }

    public SavePostulantResource setCivil_status(String civil_status) {
        this.civil_status = civil_status;
        return this;
    }
}
