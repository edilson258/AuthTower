package com.edilson258.authtower.core.infrasctructure.database;

import com.edilson258.authtower.core.entity.Partner;
import com.edilson258.authtower.core.entity.Principal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "partners")
public class PartnerJPA {
    @Id
    private String id;

    @Column(unique = true, nullable = false)
    private String email;

    public PartnerJPA() {
    }

    public PartnerJPA(String id, String email) {
        this.id = id;
        this.email = email;
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

    public static PartnerJPA fromDomain(Partner partner) {
        return new PartnerJPA(partner.getId(), partner.getEmail());
    }

    public Partner toDomain() {
        return new Partner(this.id, this.email);
    }
}
