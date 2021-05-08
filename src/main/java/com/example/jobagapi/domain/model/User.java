package com.example.jobagapi.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")

public class User extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    private Long id;  //SOLOID
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="postulant_id",referencedColumnName = "id")
    private Postulant postulant;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="employeer_id",referencedColumnName = "id")
    private Employeer employeer;

    @NotNull
    @Column(unique = true)
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

    public User (){}
    public User(@NotNull Long id, @NotNull Postulant postulant, @NotNull Employeer employeer,@NotNull String firstname, @NotNull String lastname,@NotNull String email, @NotNull Long number,@NotNull String password) {
        this.id = id;
        this.postulant = postulant;
        this.employeer = employeer;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.number = number;
        this.password = password;
    }


    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public User setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;

    }

    public User setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getNumber() {
        return number;
    }

    public User setNumber(Long number) {
        this.number = number;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Postulant getPostulant() {
        return postulant;
    }

    public void setPostulant(Postulant postulant) {
        this.postulant = postulant;

    }

    public Employeer getEmployeer() {
        return employeer;
    }

    public void setEmployeer(Employeer employeer) {
        this.employeer = employeer;
    }
}
