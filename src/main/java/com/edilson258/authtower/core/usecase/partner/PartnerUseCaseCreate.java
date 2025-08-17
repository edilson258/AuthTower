package com.edilson258.authtower.core.usecase.partner;

import com.edilson258.authtower.core.Constants;
import com.edilson258.authtower.core.dto.PartnerDTOCreate;
import com.edilson258.authtower.core.entity.Partner;
import com.edilson258.authtower.core.exception.AuthTowerException;
import com.edilson258.authtower.core.exception.AuthTowerExceptionKind;
import com.edilson258.authtower.core.repository.PartnerRepository;
import com.edilson258.authtower.core.service.JWTService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PartnerUseCaseCreate {
    private final PartnerRepository partnerRepository;
    private final JWTService jwtService;

    public PartnerUseCaseCreate(PartnerRepository partnerRepository, JWTService jwtService) {
        this.partnerRepository = partnerRepository;
        this.jwtService = jwtService;
    }

    public String execute(PartnerDTOCreate input) throws AuthTowerException {
        Optional<Partner> partnerWithEmail = partnerRepository.findByEmail(input.email());
        if (partnerWithEmail.isPresent()) {
            throw new AuthTowerException(AuthTowerExceptionKind.ENTRY_ALREADY_EXISTS, "Email is already used");
        }
        String partnerId = UUID.randomUUID().toString();
        Partner partner = new Partner(partnerId, input.email());
        partnerRepository.save(partner);
        return jwtService.generateAccessToken(partnerId, Constants.accessTokenDuration15m);
    }
}
