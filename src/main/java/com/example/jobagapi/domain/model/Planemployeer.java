package com.example.jobagapi.domain.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Table(name ="plansemployeer")

public class Planemployeer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @Length(max = 50)
    private String description;

    private int limit_videoconference;
    private int limit_modification;
    private boolean asistence;
    private Date duration;

    @OneToOne( fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employeer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Employeer employeer;

    public Planemployeer(Long id, String description, int limit_videoconference, int limit_modification, boolean asistence, Date duration, Employeer employeer) {
        this.id = id;
        this.description = description;
        this.limit_videoconference = limit_videoconference;
        this.limit_modification = limit_modification;
        this.asistence = asistence;
        this.duration = duration;
        this.employeer = employeer;
    }

    public Planemployeer(){}

    public Long getId() {
        return id;
    }

    public Planemployeer setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Planemployeer setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getLimit_videoconference() {
        return limit_videoconference;
    }

    public Planemployeer setLimit_videoconference(int limit_videoconference) {
        this.limit_videoconference = limit_videoconference;
        return this;

    }

    public int getLimit_modification() {
        return limit_modification;
    }

    public Planemployeer setLimit_modification(int limit_modification) {
        this.limit_modification = limit_modification;
        return this;
    }

    public boolean isAsistence() {
        return asistence;
    }

    public Planemployeer setAsistence(boolean asistence) {
        this.asistence = asistence;
        return this;
    }

    public Date getDuration() {
        return duration;
    }

    public Planemployeer setDuration(Date duration) {
        this.duration = duration;
        return this;
    }

    public Employeer getEmployeer() {
        return employeer;
    }

    public Planemployeer setEmployeer(Employeer employeer) {
        this.employeer = employeer;
        return this;
    }
}
