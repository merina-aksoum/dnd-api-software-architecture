package test.player.domain;

import main.player.domain.Email;
import main.player.domain.exception.InvalidEmailException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmailTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   ", "\t"})
    void email_blank_isInvalid(String blank) {
        assertThrows(InvalidEmailException.class, () -> new Email(blank));
    }

    @ParameterizedTest
    @ValueSource(strings = {"alice@example.com", "gaben@valvesoftware.com", "bob@yahoo.com", "alice", "google.com"})
    void email_isValid(String email) {
        assertThrows(InvalidEmailException.class, () -> new Email(email));
    }
}