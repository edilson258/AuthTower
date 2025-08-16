package com.edilson258.authtower.core.usecase;

import com.edilson258.authtower.core.dto.UserDTOCreate;
import com.edilson258.authtower.core.entity.UserIdentity;
import com.edilson258.authtower.core.exception.AuthTowerException;
import com.edilson258.authtower.core.exception.AuthTowerExceptionKind;
import com.edilson258.authtower.core.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserUseCaseCreate {
    private final UserRepository userRepository;

    public UserUseCaseCreate(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserIdentity execute(UserDTOCreate userDTOCreate) throws AuthTowerException {
        // TODO: check based on partner ID
        Optional<UserIdentity> userWithEmail = userRepository.findByEmail(userDTOCreate.email());
        if (userWithEmail.isPresent()) {
            throw new AuthTowerException(AuthTowerExceptionKind.ENTRY_ALREADY_EXISTS, "Email is already used");
        }
        String userId = UUID.randomUUID().toString();
        UserIdentity userIdentity = new UserIdentity(userId, userDTOCreate.email(), userDTOCreate.password());
        userRepository.save(userIdentity);
        return userIdentity;
    }
}
