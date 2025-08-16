package com.example.demo;

import java.util.Optional;

public interface PrincipalRepository {
    void insert(Principal principal);
    Optional<Principal> findByEmail(String email);
}
