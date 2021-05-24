package com.example.jobagapi.resource;

import com.example.jobagapi.domain.model.AuditModel;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class PostulantResource extends UserResource {

    private String civil_status;

    public PostulantResource(){
        super();
    }

    public PostulantResource(Long id, @NotNull String firstname, @NotNull String lastname, @NotNull String email, @NotNull Long number, @NotNull String password, String document, String civil_status) {
        super(id, firstname, lastname, email, number, password, document);
        this.civil_status = civil_status;

    }
    public String getCivil_status() {
        return civil_status;
    }

    public PostulantResource setCivil_status(String civil_status) {
        this.civil_status = civil_status;
        return this;
    }
}
