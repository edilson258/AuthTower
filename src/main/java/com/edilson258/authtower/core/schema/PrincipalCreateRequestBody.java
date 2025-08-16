package com.edilson258.authtower.core.schema;

import jakarta.validation.constraints.*;

public record PrincipalCreateRequestBody(
        @NotBlank(message = "Email field is required")
        @Email(message = "Email must be valid")
        String email,
        @NotBlank(message = "Password field is required")
        @Size(min = 8, message = "Password must be at least 8 characters")
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",
                message = "Password must contain at least one uppercase, lowercase and digit")
        String password
) {
}
