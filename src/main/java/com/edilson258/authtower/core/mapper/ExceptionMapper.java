package com.edilson258.authtower.core.mapper;

import com.edilson258.authtower.core.exception.AuthTowerException;
import com.edilson258.authtower.core.exception.AuthTowerExceptionKind;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ExceptionMapper {
    private static final List<AuthTowerExceptionKind> sensitiveAuthTowerExceptionKinds
            = List.of(AuthTowerExceptionKind.INFRASTRUCTURE_FAILURE);

    public static ResponseEntity<String> mapAuthTowerExceptionToResponseIdentity(AuthTowerException e) {
        HttpStatus httpStatus = switch (e.getKind()) {
            case ENTRY_NOT_FOUND -> HttpStatus.NOT_FOUND;
            case ENTRY_ALREADY_EXISTS -> HttpStatus.CONFLICT;
            case ENTRY_IS_INVALID -> HttpStatus.UNPROCESSABLE_ENTITY;
            case INFRASTRUCTURE_FAILURE -> HttpStatus.INTERNAL_SERVER_ERROR;
        };
        return ResponseEntity.status(httpStatus).body(maskSensitiveErrorMessage(e));
    }

    private static String maskSensitiveErrorMessage(AuthTowerException e) {
        if (sensitiveAuthTowerExceptionKinds.contains(e.getKind())) {
            return "Internal Server Error";
        }
        return e.getMessage();
    }
}
