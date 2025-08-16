package com.edilson258.authtower.core.dto;

import com.edilson258.authtower.core.schema.PrincipalCreateRequestBody;

public record PrincipalDTOCreate(String email, String password) {
    public static PrincipalDTOCreate fromRequestBody(PrincipalCreateRequestBody principalCreateRequestBody) {
        return new PrincipalDTOCreate(principalCreateRequestBody.email(), principalCreateRequestBody.password());
    }
}
