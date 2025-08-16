package com.edilson258.authtower.core.infrasctructure.database;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//
import com.edilson258.authtower.core.entity.Principal;

@Entity
@Table(name = "principals")
public class PrincipalJPA {
    @Id
    private String id;

    @Column
    private String email;

    @Column
    private String passwordHash;

    public PrincipalJPA() {
    }

    public PrincipalJPA(String id, String email, String passwordHash) {
        this.id = id;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public static PrincipalJPA from(Principal principal) {
        return new PrincipalJPA(principal.getId(), principal.getEmail(), principal.getPasswordHash());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Principal toDomain() {
        return new Principal(this.id, this.email, this.passwordHash);
    }
}
