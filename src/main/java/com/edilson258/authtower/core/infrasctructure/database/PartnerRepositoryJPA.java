package com.edilson258.authtower.core.infrasctructure.database;

import com.edilson258.authtower.core.exception.AuthTowerException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PartnerRepositoryJPA extends JpaRepository<PartnerJPA, String> {
    Optional<PartnerJPA> findByEmail(String email) throws AuthTowerException;
}
