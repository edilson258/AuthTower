package com.edilson258.authtower.core.exception;

public class AuthTowerException extends RuntimeException {
    private final AuthTowerExceptionKind category;

    public AuthTowerException(AuthTowerExceptionKind category, String message) {
        super(message);

        this.category = category;
    }

    public AuthTowerExceptionKind getKind() {
        return category;
    }
}
