package com.edilson258.authtower.core.entity;

public class Partner {
    private final String id;
    private final String email;

    public Partner(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
