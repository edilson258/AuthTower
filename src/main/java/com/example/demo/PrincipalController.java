package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

record PrincipalCreateForm(String email, String password) {
}

@RestController
@RequestMapping("/principals")
public class PrincipalController {
    private final PrincipalUseCaseCreate principalUseCaseCreate;

    public PrincipalController(PrincipalUseCaseCreate principalUseCaseCreate) {
        this.principalUseCaseCreate = principalUseCaseCreate;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody PrincipalCreateForm form) {
        PrincipalCreateDTO dto = new PrincipalCreateDTO(form.email(), form.password());
        try {
            Principal principal = this.principalUseCaseCreate.execute(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(principal);
        } catch (PrincipalUseCaseCreateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}
