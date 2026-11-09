package test.player.domain;

import main.player.domain.Username;
import main.player.domain.exception.InvalidUsernameException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UsernameTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   ", "\t"})
    void username_blank_is_refused(String blankName) {
        assertThrows(InvalidUsernameException.class, () -> new Username(blankName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Bob", "Xx_4lic3_l0v3r_xX", "Alice"})
    void username_respects_length(String value) {
        assertThrows(InvalidUsernameException.class, () -> new Username(value));
    }
}