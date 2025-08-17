package com.edilson258.authtower.core.schema;

import com.edilson258.authtower.core.dto.PartnerDTOCreate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record PartnerFormCreate(
        @NotBlank(message = "Email field is required")
        @Email(message = "Email must be valid")
        String email
) {
    public PartnerDTOCreate toDTO() {
        return new PartnerDTOCreate(this.email);
    }
}
