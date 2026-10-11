package com.payflow.domain.model.account;

import com.payflow.domain.exception.InvalidAccountIdException;

import java.util.UUID;

public record AccountId(UUID value) {

    public AccountId {
        if (value == null) {
            throw new InvalidAccountIdException("Account id must not be null");
        }
    }
}
