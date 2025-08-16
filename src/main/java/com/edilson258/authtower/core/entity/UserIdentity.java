package com.edilson258.authtower.core.entity;

public class UserIdentity {
    private final String id;
    private final String email;
    private final String passwordHash;

    public UserIdentity(String id, String email, String passwordHash) {
        this.id = id;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}
