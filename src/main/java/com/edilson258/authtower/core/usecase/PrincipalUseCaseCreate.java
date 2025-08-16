package com.edilson258.authtower.core.usecase;

import com.edilson258.authtower.core.dto.PrincipalDTOCreate;
import com.edilson258.authtower.core.entity.Principal;
import com.edilson258.authtower.core.exception.AuthTowerException;
import com.edilson258.authtower.core.exception.AuthTowerExceptionKind;
import com.edilson258.authtower.core.repository.PrincipalRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PrincipalUseCaseCreate {
    private final PrincipalRepository principalRepository;

    public PrincipalUseCaseCreate(PrincipalRepository principalRepository) {
        this.principalRepository = principalRepository;
    }

    public Principal execute(PrincipalDTOCreate principalDTOCreate) throws AuthTowerException {
        // TODO: check based on partner ID
        Optional<Principal> userWithEmail = principalRepository.findByEmail(principalDTOCreate.email());
        if (userWithEmail.isPresent()) {
            throw new AuthTowerException(AuthTowerExceptionKind.ENTRY_ALREADY_EXISTS, "Email is already used");
        }
        String userId = UUID.randomUUID().toString();
        Principal principal = new Principal(userId, principalDTOCreate.email(), principalDTOCreate.password());
        principalRepository.save(principal);
        return principal;
    }
}
