package com.payflow.domain.model.user;

import com.payflow.domain.exception.InvalidUserIdException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserIdTest {

    @Test
    void shouldKeepTheGivenUuid() {
        UUID uuid = UUID.randomUUID();
        UserId userId = new UserId(uuid);

        assertEquals(uuid, userId.value());
    }

    @Test
    void shouldRejectNull() {
        assertThrows(InvalidUserIdException.class, () -> new UserId(null) );
    }
}
