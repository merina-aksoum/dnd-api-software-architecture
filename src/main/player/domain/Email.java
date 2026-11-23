package main.player.domain;

import main.player.domain.exception.EmptyFieldException;
import main.player.domain.exception.InvalidEmailException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record Email(String value) {
    public Email {
        boolean isFound = false;
        if (value != null) {
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
            Matcher matcher = pattern.matcher(value);
            isFound = matcher.find();
        }

        if (value == null || value.isBlank()) {
            throw new EmptyFieldException("email");
        }

        if (!isFound) {
            throw new InvalidEmailException(value);
        }
    }
}