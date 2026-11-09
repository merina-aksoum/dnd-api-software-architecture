package test.player.domain;

import main.player.domain.Password;
import main.player.domain.exception.InvalidPasswordException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static test.player.domain.fixtures.PasswordFixture.OTHER_PASSWORD;

public class PasswordTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   ", "\t"})
    void password_blank_isRefused(String blankValue) {
        assertThrows(InvalidPasswordException.class, () -> new Password(blankValue));
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345", "awe", "q1w2e3;;", OTHER_PASSWORD})
    void password_isInvalid(String password) {
        assertThrows(InvalidPasswordException.class, () -> new Password((password)));
    }
}