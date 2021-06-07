package com.example.jobagapi.resource;

import com.example.jobagapi.domain.model.MailMessage;

public class MailMessageResource {

    int id;
    String message;
    String document;
    private boolean aceppt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isAceppt() {
        return aceppt;
    }

    public MailMessageResource setAceppt(boolean aceppt) {
        this.aceppt = aceppt;
        return this;
    }
}
