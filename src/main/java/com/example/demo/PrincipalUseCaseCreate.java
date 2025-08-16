package com.example.demo;

import java.util.UUID;

public class PrincipalUseCaseCreate {
    private final PrincipalRepository principalRepository;

    PrincipalUseCaseCreate(PrincipalRepository principalRepository) {
        this.principalRepository = principalRepository;
    }

    public Principal execute(PrincipalCreateDTO dto) {
        Principal principal = new Principal(UUID.randomUUID().toString(), dto.email(), dto.password());
        this.principalRepository.insert(principal);
        return principal;
    }
}
