package com.payflow.domain.model.transfer;

import com.payflow.domain.exception.InvalidTransferIdException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
