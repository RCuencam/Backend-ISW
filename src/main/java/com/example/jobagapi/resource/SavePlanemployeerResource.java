package com.example.jobagapi.resource;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class SavePlanemployeerResource {

    @NotNull
    @Length(max = 50)
    private String description;

    private int limit_videoconference;
    private int limit_modification;
    private boolean asistence;
    private Date duration;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLimit_videoconference() {
        return limit_videoconference;
    }

    public void setLimit_videoconference(int limit_videoconference) {
        this.limit_videoconference = limit_videoconference;
    }

    public int getLimit_modification() {
        return limit_modification;
    }

    public void setLimit_modification(int limit_modification) {
        this.limit_modification = limit_modification;
    }

    public boolean isAsistence() {
        return asistence;
    }

    public void setAsistence(boolean asistence) {
        this.asistence = asistence;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }
}
