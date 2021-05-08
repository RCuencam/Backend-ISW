package com.example.jobagapi.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "interviews")

public class Interview extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @NotNull
    public long id;
    @NotNull
    @Column(unique = true)
    public String link;
    @NotNull
    public double duration;
    @NotNull
    public double begin_hour;
    public double end_hour;
    @NotNull
    public Date date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "interviews_id", nullable = false)
    @JsonIgnore
    private Postulant postulant;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getBegin_hour() {
        return begin_hour;
    }

    public void setBegin_hour(double begin_hour) {
        this.begin_hour = begin_hour;
    }

    public double getEnd_hour() {
        return end_hour;
    }

    public void setEnd_hour(double end_hour) {
        this.end_hour = end_hour;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
