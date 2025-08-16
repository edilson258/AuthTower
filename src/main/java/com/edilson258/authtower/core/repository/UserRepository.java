package com.edilson258.authtower.core.repository;

import com.edilson258.authtower.core.entity.UserIdentity;
import com.edilson258.authtower.core.exception.AuthTowerException;

import java.util.Optional;

public interface UserRepository {
    void save(UserIdentity userIdentity) throws AuthTowerException;
    Optional<UserIdentity> findByEmail(String email) throws AuthTowerException;
}
