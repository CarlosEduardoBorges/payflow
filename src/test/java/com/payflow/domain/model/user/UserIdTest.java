package com.payflow.domain.model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.payflow.domain.exception.InvalidUserIdException;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class UserIdTest {

    @Test
    void shouldKeepTheGivenUuid() {
        UUID uuid = UUID.randomUUID();
        UserId userId = new UserId(uuid);

        assertEquals(uuid, userId.value());
    }

    @Test
    void shouldRejectNull() {
        assertThrows(InvalidUserIdException.class, () -> new UserId(null));
    }
}
