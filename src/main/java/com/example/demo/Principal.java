package com.example.demo;

public class Principal {
    private final String id;
    private final String email;
    private final String password;

    public Principal(String id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return this.id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
