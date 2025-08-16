package com.example.demo;

import org.springframework.web.bind.annotation.*;

record PrincpalCreateForm(String email, String password) {
}

record PrincipalView(String id, String email, String password) {
}

@RestController
@RequestMapping("/principals")
public class PrincipalController {
    private final PrincipalUseCaseCreate principalUseCaseCreate;

    public PrincipalController(PrincipalUseCaseCreate principalUseCaseCreate) {
        this.principalUseCaseCreate = principalUseCaseCreate;
    }

    @PostMapping
    public Principal create(@RequestBody PrincpalCreateForm form) {
        PrincipalCreateDTO dto = new PrincipalCreateDTO(form.email(), form.password());
        Principal principal = this.principalUseCaseCreate.execute(dto);
        return principal;
    }
}
