package main.player.domain;

import java.util.Objects;

import main.player.domain.exception.EmptyFieldException;
import main.player.domain.exception.PasswordTooShortException;

public record Password(String value) {
    public Password {

        Objects.requireNonNull(value, "Password must not be null");

        if (value == null || value.isBlank()) {
            throw new EmptyFieldException("password");
        }

        if (value.length() < 8) {
            throw new PasswordTooShortException();
        }
    }
}