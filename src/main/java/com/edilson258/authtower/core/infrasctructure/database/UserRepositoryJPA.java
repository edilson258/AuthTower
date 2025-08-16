package com.edilson258.authtower.core.infrasctructure.database;

import com.edilson258.authtower.core.exception.AuthTowerExceptionKind;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.edilson258.authtower.core.entity.UserIdentity;
import com.edilson258.authtower.core.exception.AuthTowerException;
import com.edilson258.authtower.core.repository.UserRepository;

import java.util.Optional;

@Repository
@Transactional
public class UserRepositoryJPA implements UserRepository {
    private final UserJpaRepository userJpaRepository;
    private final EntityManager entityManager;

    public UserRepositoryJPA(UserJpaRepository userJpaRepository, EntityManager entityManager) {
        this.userJpaRepository = userJpaRepository;
        this.entityManager = entityManager;
    }

    @Override
    public void save(UserIdentity userIdentity) throws AuthTowerException {
        try {
            userJpaRepository.save(UserJpaEntity.from(userIdentity));
        } catch (AuthTowerException e) {
            throw new AuthTowerException(AuthTowerExceptionKind.INFRASTRUCTURE_FAILURE, e.getMessage());
        }
    }

    @Override
    public Optional<UserIdentity> findByEmail(String email) throws AuthTowerException {
        try {
            return userJpaRepository.findByEmail(email).map(UserJpaEntity::toDomain);
        } catch (AuthTowerException e) {
            throw new AuthTowerException(AuthTowerExceptionKind.INFRASTRUCTURE_FAILURE, e.getMessage());
        }
    }
}
