package com.edilson258.authtower.core.view;

import com.edilson258.authtower.core.entity.UserIdentity;

public record UserView(String id, String email) {
    public static UserView fromUserEntity(UserIdentity userIdentity) {
        return new UserView(userIdentity.getId(), userIdentity.getEmail());
    }
}
