package com.edilson258.authtower.core.controller;

import jakarta.validation.Valid;
//
import com.edilson258.authtower.core.dto.UserDTOCreate;
import com.edilson258.authtower.core.entity.UserIdentity;
import com.edilson258.authtower.core.exception.AuthTowerException;
import com.edilson258.authtower.core.mapper.ExceptionMapper;
import com.edilson258.authtower.core.schema.UserCreateRequestBody;
import com.edilson258.authtower.core.usecase.UserUseCaseCreate;
import com.edilson258.authtower.core.view.UserView;
//
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserUseCaseCreate userUseCaseCreate;

    public UserController(UserUseCaseCreate userUseCaseCreate) {
        this.userUseCaseCreate = userUseCaseCreate;
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody UserCreateRequestBody body, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        try {
            UserDTOCreate dto = UserDTOCreate.fromRequestBody(body);
            UserIdentity user = userUseCaseCreate.execute(dto);
            UserView userView = UserView.fromUserEntity(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(userView);
        } catch (AuthTowerException e) {
            return ExceptionMapper.mapAuthTowerExceptionToResponseIdentity(e);
        }
    }
}
