package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
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
