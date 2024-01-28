package com.social.app.socialapp.response;

public class AuthResponse {

    private String token;
    private String message;

    public AuthResponse() {
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public String getMessage() {
        return message;
    }

    public AuthResponse(String token, String message) {
        this.token = token;
        this.message = message;
    }
}
