package player.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import player.domain.exception.InvalidPasswordException;

public record Password(String value) {
    public Password {
        // What is a secure password?
        // At least 8 characters long
        // >= 1 digit
        // >= 1 special character
        // >= 1 lowercase
        // >= 1 uppercase
        final int MIN_LENGTH = 8;
        String hasDigit = "?=.*\\d";
        String hasSpecialChar = "?=.*[^a-zA-Z0-9]";
        String hasLowercase = "?=.*[a-z]";
        String hasUpperCase = "?=.*[A-Z]";
        String regexCheck = String.format("^(%s)(%s)(%s)(%s).{%d,}$",
                hasDigit,
                hasSpecialChar,
                hasLowercase,
                hasUpperCase,
                MIN_LENGTH);
        Pattern pattern = Pattern.compile(regexCheck);
        Matcher matcher = pattern.matcher(value);
        final boolean IS_VALID = !matcher.find() && value.length() >= MIN_LENGTH;

        if (!IS_VALID) {
            throw new InvalidPasswordException();
        }
    }
}