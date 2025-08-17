package com.edilson258.authtower.core.repository;

import com.edilson258.authtower.core.entity.Partner;
import com.edilson258.authtower.core.exception.AuthTowerException;

import java.util.Optional;

public interface PartnerRepository {
    void save(Partner partner) throws AuthTowerException;
    Optional<Partner> findById(String id) throws AuthTowerException;
    Optional<Partner> findByEmail(String email) throws AuthTowerException;
}
