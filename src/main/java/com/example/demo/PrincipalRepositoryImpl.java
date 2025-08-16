package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Repository
public class PrincipalRepositoryImpl implements PrincipalRepository {
    private final List<Principal> principals;

    PrincipalRepositoryImpl() {
        principals = new ArrayList<>();
    }

    @Override
    public void insert(Principal principal) {
        this.principals.add(principal);
    }

    @Override
    public Optional<Principal> findByEmail(String email) {
        return principals.stream().filter(p -> Objects.equals(p.getEmail(), email)).findFirst();
    }
}
