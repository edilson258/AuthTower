package com.edilson258.authtower.core.infrasctructure.database;

import com.edilson258.authtower.core.exception.AuthTowerExceptionKind;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.edilson258.authtower.core.entity.Principal;
import com.edilson258.authtower.core.exception.AuthTowerException;
import com.edilson258.authtower.core.repository.PrincipalRepository;

import java.util.Optional;

@Repository
@Transactional
public class PrincipalRepositoryImplementationJPA implements PrincipalRepository {
    private final PrincipalRepositoryJPA principalRepositoryJPA;
    private final EntityManager entityManager;

    public PrincipalRepositoryImplementationJPA(PrincipalRepositoryJPA principalRepositoryJPA, EntityManager entityManager) {
        this.principalRepositoryJPA = principalRepositoryJPA;
        this.entityManager = entityManager;
    }

    @Override
    public void save(Principal principal) throws AuthTowerException {
        try {
            principalRepositoryJPA.save(PrincipalJPA.from(principal));
        } catch (AuthTowerException e) {
            throw new AuthTowerException(AuthTowerExceptionKind.INFRASTRUCTURE_FAILURE, e.getMessage());
        }
    }

    @Override
    public Optional<Principal> findByEmail(String email) throws AuthTowerException {
        try {
            return principalRepositoryJPA.findByEmail(email).map(PrincipalJPA::toDomain);
        } catch (AuthTowerException e) {
            throw new AuthTowerException(AuthTowerExceptionKind.INFRASTRUCTURE_FAILURE, e.getMessage());
        }
    }
}
