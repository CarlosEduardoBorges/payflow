package com.payflow.domain.model.transfer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.payflow.domain.exception.InvalidMoneyException;
import java.math.BigDecimal;
import java.util.Currency;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    private static final Currency BRL = Currency.getInstance("BRL");

    @Test
    void shouldRejectNullAmount() {
        assertThrows(InvalidMoneyException.class, () -> new Money(null, BRL));
    }

    @Test
    void shouldRejectNullCurrency() {
        BigDecimal amount = new BigDecimal("10.00");

        assertThrows(InvalidMoneyException.class, () -> new Money(amount, null));
    }

    @Test
    void shouldNormalizeScaleToTwoDecimals() {
        Money money = new Money(new BigDecimal("10.5"), BRL);

        assertEquals(new BigDecimal("10.50"), money.amount());
    }

    @Test
    void shouldRoundToTwoDecimals() {
        Money money = new Money(new BigDecimal("10.125"), BRL);

        assertEquals(new BigDecimal("10.12"), money.amount());
    }

    @Test
    void shouldRejectNegativeAmount() {
        BigDecimal amount = new BigDecimal("-0.01");

        assertThrows(InvalidMoneyException.class, () -> new Money(amount, BRL));
    }

    @Test
    void shouldRejectNegativeAmountThatRoundsToZero() {
        BigDecimal amount = new BigDecimal("-0.001");

        assertThrows(InvalidMoneyException.class, () -> new Money(amount, BRL));
    }

    @Test
    void shouldAcceptZero() {
        BigDecimal amount = new BigDecimal("0.00");
        Money money = new Money(amount, BRL);

        assertEquals(new BigDecimal("0.00"), money.amount());
    }

    @ParameterizedTest(name = "rejects [{0}]")
    @ValueSource(strings = {"USD", "EUR", "GBP", "JPY", "ARS"})
    void shouldRejectNonBrlCurrency(String currency) {
        Currency otherCurrency = Currency.getInstance(currency);
        assertThrows(InvalidMoneyException.class, () -> new Money(BigDecimal.TEN, otherCurrency));
    }
}
