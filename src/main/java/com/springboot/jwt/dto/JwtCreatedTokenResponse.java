package com.springboot.jwt.dto;

public final class JwtCreatedTokenResponse {
    private final String token;

    public JwtCreatedTokenResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
