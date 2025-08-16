package com.edilson258.authtower.core.dto;

import com.edilson258.authtower.core.schema.UserCreateRequestBody;

public record UserDTOCreate(String email, String password) {
    public static UserDTOCreate fromRequestBody(UserCreateRequestBody userCreateRequestBody) {
        return new UserDTOCreate(userCreateRequestBody.email(), userCreateRequestBody.password());
    }
}
