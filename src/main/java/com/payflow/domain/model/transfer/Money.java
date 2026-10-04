package com.payflow.domain.model.transfer;

import java.math.BigDecimal;
import java.util.Currency;


public record Money(BigDecimal amount, Currency currency) {
}
