package com.example.jobagapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
<<<<<<< HEAD
=======

>>>>>>> 8be72bbdb8dea4f2ad84fbd7c97bb119ef080bd5
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "skill")
public class Skill extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
<<<<<<< HEAD

    @Column(name = "id")
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "skill_id", nullable = false)
//    @JsonIgnore
//    private ProfessionalProfile professionalProfile;
//    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })

=======
    @Column(name = "id")
    private Long id;

>>>>>>> 8be72bbdb8dea4f2ad84fbd7c97bb119ef080bd5
    @NotNull
    private String name;

    @NotNull
    private String description;

<<<<<<< HEAD
    public Skill () {}
=======
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "skill_id", nullable = false)
    @JsonIgnore
    private ProfessionalProfile professionalProfile;

>>>>>>> 8be72bbdb8dea4f2ad84fbd7c97bb119ef080bd5
    public Long getId() {
        return id;
    }

<<<<<<< HEAD
    public Skill setId(Long id) {
        this.id = id;
        return this;
=======
    public void setId(Long id) {
        this.id = id;
>>>>>>> 8be72bbdb8dea4f2ad84fbd7c97bb119ef080bd5
    }

    public String getName() {
        return name;
    }

<<<<<<< HEAD
    public Skill setName(String name) {
        this.name = name;
        return this;
=======
    public void setName(String name) {
        this.name = name;
>>>>>>> 8be72bbdb8dea4f2ad84fbd7c97bb119ef080bd5
    }

    public String getDescription() {
        return description;
    }

<<<<<<< HEAD
    public Skill setDescription(String description) {
        this.description = description;
        return this;
=======
    public void setDescription(String description) {
        this.description = description;
>>>>>>> 8be72bbdb8dea4f2ad84fbd7c97bb119ef080bd5
    }
}
