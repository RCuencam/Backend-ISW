package com.example.jobagapi.resource;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class UserResource {

    private Long id;


    @NotNull
    private String firstname;

    @NotNull
    private String lastname;

    @Column(unique = true)
    @NotNull
    private String email;

    @NotNull
    private Long number;

    @NotNull
    private String password;

    private String document;

    public UserResource (){
        super();
    }


    public UserResource(Long id,  @NotNull String firstname,  @NotNull String lastname,  @NotNull String email, @NotNull Long number, @NotNull String password, String document) {
        super();
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.number = number;
        this.password = password;
        this.document = document;
    }

    public Long getId() {
        return id;
    }

    public UserResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public UserResource setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public UserResource setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getNumber() {
        return number;
    }

    public UserResource setNumber(Long number) {
        this.number = number;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserResource setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getDocument() {
        return document;
    }

    public UserResource setDocument(String document) {
        this.document = document;
        return this;
    }
}
