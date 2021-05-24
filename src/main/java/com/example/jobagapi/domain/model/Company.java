package com.example.jobagapi.domain.model;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="company")
public class Company extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @Length(max = 100)
    String name;
    @NotNull
    @Length(max = 100)
    String description;
    @NotNull
    @Length(max = 100)
    String sector;
    @NotNull
    @Length(max = 100)
    String logo;


    Long ruc;

    @NotNull
    @Length(max = 100)
    String dirección;




    @ManyToOne( fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employeer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Employeer employeer;

    public Company(Long id, String name, String description, String sector, String logo, Long ruc, String dirección, Employeer employeer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sector = sector;
        this.logo = logo;
        this.ruc = ruc;
        this.dirección = dirección;
        this.employeer = employeer;
    }

    public Company(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Long getRuc() {
        return ruc;
    }

    public void setRuc(Long ruc) {
        this.ruc = ruc;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public Employeer getEmployeer() {
        return employeer;
    }

    public void setEmployeer(Employeer employeer) {
        this.employeer = employeer;
    }
}
