package com.edilson258.authtower.core.view;

import com.edilson258.authtower.core.entity.Principal;

public record PrincipalView(String id, String email) {
    public static PrincipalView fromPrincipal(Principal principal) {
        return new PrincipalView(principal.getId(), principal.getEmail());
    }
}
