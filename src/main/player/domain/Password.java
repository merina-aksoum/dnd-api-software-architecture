package player.domain;

import player.domain.exception.InvalidPasswordException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record Password(String value) {
    public Password {
        boolean isValid = false;
        if (value != null) {
            String regexCheck = "^.{8,}$";
            Pattern pattern = Pattern.compile(regexCheck);
            Matcher matcher = pattern.matcher(value);
            isValid = matcher.find();
        }

        if (!isValid || value.isBlank()) {
            throw new InvalidPasswordException();
        }
    }
}