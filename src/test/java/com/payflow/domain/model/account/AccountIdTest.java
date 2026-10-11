package com.payflow.domain.model.account;

import com.payflow.domain.exception.InvalidAccountIdException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AccountIdTest {

    @Test
    void shouldKeepTheGivenUuid() {
        UUID uuid = UUID.randomUUID();
        AccountId accountId = new AccountId(uuid);

        assertEquals(uuid, accountId.value());
    }

    @Test
    void shouldRejectNull() {
        assertThrows(InvalidAccountIdException.class, () -> new AccountId(null));
    }
}
