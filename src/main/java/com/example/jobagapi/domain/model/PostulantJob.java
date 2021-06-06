package com.example.jobagapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "postulantjob")
public class PostulantJob extends AuditModel{
    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Postulant getPostulant() {
        return postulant;
    }

    public PostulantJob setPostulant(Postulant postulant) {
        this.postulant = postulant;
        return this;
    }

    //Relacion con postulante
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_postulant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Postulant postulant;

    public JobOffer getJobOffer() {
        return jobOffer;
    }

    public PostulantJob setJobOffer(JobOffer jobOffer) {
        this.jobOffer = jobOffer;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_joboffer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private JobOffer jobOffer;

    //Variable booleano
    @NotNull
    private boolean aceppt;

    public PostulantJob(boolean aceppt) {
        this.aceppt = aceppt;
    }

    public PostulantJob() {
    }

    public boolean isAceppt() {
        return aceppt;
    }

    public PostulantJob setAceppt(boolean aceppt) {
        this.aceppt = aceppt;
        return this;
    }

    public Long getId() {
        return id;
    }

    public PostulantJob setId(Long id) {
        this.id = id;
        return this;
    }
}
