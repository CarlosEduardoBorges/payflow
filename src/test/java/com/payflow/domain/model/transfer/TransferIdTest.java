package com.payflow.domain.model.transfer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.payflow.domain.exception.InvalidTransferIdException;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class TransferIdTest {

    @Test
    void shouldKeepTheGivenUuid() {
        UUID uuid = UUID.randomUUID();
        TransferId transferId = new TransferId(uuid);

        assertEquals(uuid, transferId.value());
    }

    @Test
    void shouldRejectNull() {
        assertThrows(InvalidTransferIdException.class, () -> new TransferId(null));
    }
}
