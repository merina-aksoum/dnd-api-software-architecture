package main.player.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.player.domain.exception.InvalidUsernameException;

public record Username(String value) {
    public Username {
        boolean isValid = false;
        if (value != null) {
            Pattern pattern = Pattern.compile("^([a-zA-z0-9_]){3,20}$");
            Matcher matcher = pattern.matcher(value);
            isValid = matcher.find();
        }

        if (!isValid || value.isBlank()) {
            throw new InvalidUsernameException();
        }
    }
}