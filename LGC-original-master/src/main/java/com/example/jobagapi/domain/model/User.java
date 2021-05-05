package com.example.jobagapi.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy =InheritanceType.JOINED) //herencia preguntar profe
@Table(name = "users")

public class User extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;  //SOLOID

    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @Column(unique = true)
    @NotNull
    private String email;
    @NotNull
    private String number;
    @NotNull
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
