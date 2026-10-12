package com.payflow.domain.model.transfer;

import com.payflow.domain.exception.InvalidMoneyException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

/**
 * Value Object que representa uma quantia monetária. O valor é normalizado para a escala da moeda
 * (HALF_EVEN) na criação, então quantias equivalentes são sempre iguais.
 */
public record Money(BigDecimal amount, Currency currency) {

    private static final String INVALID_MESSAGE = "Money amount and currency must not be null";
    private static final String NEGATIVE_MESSAGE = "Money amount must not be negative";
    private static final String INVALID_CURRENCY_MESSAGE = "Money currency must be BRL";

    private static final Currency BRL = Currency.getInstance("BRL");

    public Money {
        if (amount == null || currency == null) {
            throw new InvalidMoneyException(INVALID_MESSAGE);
        }

        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidMoneyException(NEGATIVE_MESSAGE);
        }

        if (!BRL.equals(currency)) {
            throw new InvalidMoneyException(INVALID_CURRENCY_MESSAGE);
        }

        amount = amount.setScale(currency.getDefaultFractionDigits(), RoundingMode.HALF_EVEN);
    }
}
