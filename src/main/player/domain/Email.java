package main.player.domain;

import main.player.domain.exception.InvalidEmailException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record Email (String value) {
    public Email {
        Pattern pattern = Pattern.compile("^(.+)@(\\S+) $.");
        Matcher matcher = pattern.matcher(value);
        final boolean IS_VALID = matcher.find();

        if (!IS_VALID) {
            throw new InvalidEmailException(value);
        }
    }
}