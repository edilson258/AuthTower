package com.edilson258.authtower.core.infrasctructure.database;

import com.edilson258.authtower.core.entity.Partner;
import com.edilson258.authtower.core.exception.AuthTowerException;
import com.edilson258.authtower.core.exception.AuthTowerExceptionKind;
import com.edilson258.authtower.core.repository.PartnerRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public class PartnerRepositoryImplJPA implements PartnerRepository {
    private final PartnerRepositoryJPA partnerRepositoryJPA;
    private final EntityManager entityManager;

    public PartnerRepositoryImplJPA(PartnerRepositoryJPA partnerRepositoryJPA, EntityManager entityManager) {
        this.partnerRepositoryJPA = partnerRepositoryJPA;
        this.entityManager = entityManager;
    }

    @Override
    public void save(Partner partner) throws AuthTowerException {
        try {
            partnerRepositoryJPA.save(PartnerJPA.fromDomain(partner));
        } catch (AuthTowerException e) {
            throw new AuthTowerException(AuthTowerExceptionKind.INFRASTRUCTURE_FAILURE, e.getMessage());
        }
    }

    @Override
    public Optional<Partner> findById(String id) throws AuthTowerException {
        try {
            return partnerRepositoryJPA.findById(id).map(PartnerJPA::toDomain);
        } catch (AuthTowerException e) {
            throw new AuthTowerException(AuthTowerExceptionKind.INFRASTRUCTURE_FAILURE, e.getMessage());
        }
    }

    @Override
    public Optional<Partner> findByEmail(String email) throws AuthTowerException {
        try {
            return partnerRepositoryJPA.findByEmail(email).map(PartnerJPA::toDomain);
        } catch (AuthTowerException e) {
            throw new AuthTowerException(AuthTowerExceptionKind.INFRASTRUCTURE_FAILURE, e.getMessage());
        }
    }
}
