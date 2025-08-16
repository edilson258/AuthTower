package com.edilson258.authtower.core.infrasctructure.database;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//
import com.edilson258.authtower.core.entity.UserIdentity;

@Entity
@Table(name = "users")
public class UserJpaEntity {
    @Id
    private String id;

    @Column
    private String email;

    @Column
    private String passwordHash;

    public UserJpaEntity(String id, String email, String passwordHash) {
        this.id = id;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public static UserJpaEntity from(UserIdentity userIdentity) {
        return new UserJpaEntity(userIdentity.getId(), userIdentity.getEmail(), userIdentity.getPasswordHash());
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

    public UserIdentity toDomain() {
        return new UserIdentity(this.id, this.email, this.passwordHash);
    }
}
