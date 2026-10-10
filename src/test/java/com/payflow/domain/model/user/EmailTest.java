package com.payflow.domain.model.user;

import com.payflow.domain.exception.InvalidEmailException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailTest {

    @Test
    void shouldNormalizeTrimAndLowerCase() {
        Email email = new Email("  Ana@X.com ");

        // (é aquilo que esperamos, e aquilo que objeto realmente guardou)
        assertEquals("ana@x.com", email.value());
    }

    @Test
    void shouldBeEqualIgnoringCase() {
        Email email1 = new Email("Ana@X.com");
        Email email2 = new Email("ana@x.com");

        assertEquals(email1, email2);
    }

    @Test
    void shouldRejectMissingAtSign() {
        assertThrows(InvalidEmailException.class, () -> new Email("abc"));
    }

    @ParameterizedTest(name = "rejects [{0}]")
    @NullAndEmptySource
    @ValueSource(strings = {"   ", "abc", "a@", "@b.com", "a b@c.com"})
    void shouldRejectInvalidEmail(String input) {
        assertThrows(InvalidEmailException.class, () -> new Email(input));
    }

}
