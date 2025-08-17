package com.edilson258.authtower.core.controller;

import com.edilson258.authtower.core.dto.PartnerDTOCreate;
import com.edilson258.authtower.core.exception.AuthTowerException;
import com.edilson258.authtower.core.mapper.ExceptionMapper;
import com.edilson258.authtower.core.schema.PartnerFormCreate;
import com.edilson258.authtower.core.usecase.partner.PartnerUseCaseCreate;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/partners")
public class PartnerController {
    private final PartnerUseCaseCreate partnerUseCaseCreate;

    public PartnerController(PartnerUseCaseCreate partnerUseCaseCreate) {
        this.partnerUseCaseCreate = partnerUseCaseCreate;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> signup(@Valid @RequestBody PartnerFormCreate form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        PartnerDTOCreate partnerDTOCreate = form.toDTO();
        try {
            String accessToken = partnerUseCaseCreate.execute(partnerDTOCreate);
            return ResponseEntity.status(HttpStatus.CREATED).body(accessToken);
        } catch (AuthTowerException e) {
            return ExceptionMapper.mapAuthTowerExceptionToResponseIdentity(e);
        }
    }
}
