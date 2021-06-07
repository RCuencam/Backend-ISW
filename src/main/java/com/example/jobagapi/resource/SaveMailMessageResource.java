package com.example.jobagapi.resource;

public class SaveMailMessageResource {

    String message;
    String document;

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

    private boolean aceppt;

    public boolean isAceppt() {
        return aceppt;
    }

    public SaveMailMessageResource setAceppt(boolean aceppt) {
        this.aceppt = aceppt;
        return this;
    }
}

