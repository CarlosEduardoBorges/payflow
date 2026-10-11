package com.payflow.domain.model.transfer;

import com.payflow.domain.exception.InvalidTransferIdException;
import java.util.UUID;

public record TransferId(UUID value) {

    public TransferId {
        if (value == null) {
            throw new InvalidTransferIdException("Transfer id must not be null");
        }
    }
}
