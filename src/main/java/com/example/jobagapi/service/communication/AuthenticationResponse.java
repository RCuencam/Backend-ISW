package com.example.jobagapi.service.communication;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {
    private Long id;
    private String username;
    private String token;

    public AuthenticationResponse(Long id, String username, String token) {
        this.id = id;
        this.username = username;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getToken() {
        return token;
    }
}