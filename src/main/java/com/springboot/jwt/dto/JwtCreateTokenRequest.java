package com.springboot.jwt.dto;

public final class JwtCreateTokenRequest {
    private final String username;
    private final String password;

    public JwtCreateTokenRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
