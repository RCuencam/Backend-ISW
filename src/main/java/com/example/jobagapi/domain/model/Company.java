package com.example.jobagapi.domain.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name ="companys")
public class Company extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 100)
    private String description;

    @NotNull
    @Size(max = 100)
    private String logo;

    private Long ruc;

    @NotNull
    @Size(max = 100)
    private String dirección;

    @OneToOne( fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_employeer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Employeer employeer;

    @ManyToOne( fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_sector_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Sector sector;

    public Company() {
    }

    public Company(Long id, String name, String description, String logo, Long ruc, String dirección) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.logo = logo;
        this.ruc = ruc;
        this.dirección = dirección;
    }


    public Long getId() {
        return id;
    }

    public Company setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Company setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getLogo() {
        return logo;
    }

    public Company setLogo(String logo) {
        this.logo = logo;
        return this;
    }

    public Long getRuc() {
        return ruc;
    }

    public Company setRuc(Long ruc) {
        this.ruc = ruc;
        return this;
    }

    public String getDirección() {
        return dirección;
    }

    public Company setDirección(String dirección) {
        this.dirección = dirección;
        return this;
    }

    public Employeer getEmployeer() {
        return employeer;
    }

    public Company setEmployeer(Employeer employeer) {
        this.employeer = employeer;
        return this;
    }

    public Sector getSector() {
        return sector;
    }

    public Company setSector(Sector sector) {
        this.sector = sector;
        return this;
    }
}
