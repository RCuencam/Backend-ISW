package com.example.jobagapi.domain.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "mailmessages")
public class MailMessage extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne( fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_postulant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Postulant postulant;

    @NotNull
    @Length(max = 100)
    private String message;

    private String document;

    @OneToOne( fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_employeer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Employeer employeer;

    @NotNull
    private boolean aceppt;

    public MailMessage(boolean aceppt) {
        this.aceppt = aceppt;
    }

    public MailMessage(int id, Postulant postulant, String message, String document, Employeer employeer){
        this.id = id;
        this.postulant = postulant;
        this.message = message;
        this. document = document;
        this.employeer = employeer;
    }

    public MailMessage(){

    }

    public boolean isAceppt() {
        return aceppt;
    }

    public MailMessage setAceppt(boolean aceppt) {
        this.aceppt = aceppt;
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Postulant getPostulant() {
        return postulant;
    }

    public void setPostulant(Postulant postulant) {
        this.postulant = postulant;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Employeer getEmployeer() {
        return employeer;
    }

    public void setEmployeer(Employeer employeer) {
        this.employeer = employeer;
    }
}
