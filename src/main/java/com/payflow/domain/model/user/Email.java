package com.payflow.domain.model.user;

import com.payflow.domain.exception.InvalidEmailException;

import java.util.Locale;
import java.util.regex.Pattern;

/**
 * Value Object que representa o e-mail de um usuário.
 * É normalizado (trim + minúsculas) e validado na criação,
 * então toda instância existente é válida e imutável.
 */
public record Email(String value) {

    private static final String INVALID_MESSAGE = "Email must be a valid address, e.g. name@domain.com";

    /** Formato esperado: parte local, "@", domínio e TLD com 2+ letras. */
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    public Email {
        if (value == null || value.isBlank()) {
            throw new InvalidEmailException(INVALID_MESSAGE);
        }

        // Normaliza antes de validar, para tolerar espaços e maiúsculas na entrada.
        value = value.trim().toLowerCase(Locale.ROOT);

        if (!EMAIL_PATTERN.matcher(value).matches()) {
            throw new InvalidEmailException(INVALID_MESSAGE);
        }
    }
}
