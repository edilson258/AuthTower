package com.edilson258.authtower.core.controller;

import jakarta.validation.Valid;
//
import com.edilson258.authtower.core.dto.PrincipalDTOCreate;
import com.edilson258.authtower.core.entity.Principal;
import com.edilson258.authtower.core.exception.AuthTowerException;
import com.edilson258.authtower.core.mapper.ExceptionMapper;
import com.edilson258.authtower.core.schema.PrincipalCreateRequestBody;
import com.edilson258.authtower.core.usecase.PrincipalUseCaseCreate;
import com.edilson258.authtower.core.view.PrincipalView;
//
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/principals")
public class PrincipalController {
    private final PrincipalUseCaseCreate principalUseCaseCreate;

    public PrincipalController(PrincipalUseCaseCreate principalUseCaseCreate) {
        this.principalUseCaseCreate = principalUseCaseCreate;
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody PrincipalCreateRequestBody body, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        try {
            PrincipalDTOCreate principalDTOCreate = PrincipalDTOCreate.fromRequestBody(body);
            Principal principal = principalUseCaseCreate.execute(principalDTOCreate);
            PrincipalView principalView = PrincipalView.fromPrincipal(principal);
            return ResponseEntity.status(HttpStatus.CREATED).body(principalView);
        } catch (AuthTowerException e) {
            return ExceptionMapper.mapAuthTowerExceptionToResponseIdentity(e);
        }
    }
}
