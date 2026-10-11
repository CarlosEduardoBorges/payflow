package com.payflow.domain.model.user;

import com.payflow.domain.exception.InvalidUserIdException;

import java.util.UUID;

public record UserId(UUID value) {
    public UserId {
        if (value == null) {
            throw new InvalidUserIdException("User id must not be null");
        }
    }
}
