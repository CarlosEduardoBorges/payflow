package com.payflow.domain.model.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.payflow.domain.exception.InvalidAccountIdException;
import java.util.UUID;
import org.junit.jupiter.api.Test;

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
