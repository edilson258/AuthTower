package com.edilson258.authtower.core.repository;

import com.edilson258.authtower.core.entity.Principal;
import com.edilson258.authtower.core.exception.AuthTowerException;

import java.util.Optional;

public interface PrincipalRepository {
    void save(Principal principal) throws AuthTowerException;
    Optional<Principal> findByEmail(String email) throws AuthTowerException;
}
