package player.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import player.domain.exception.InvalidUsernameException;

public record Username(String value) {
    public Username {
        String notLetterCheck = "[^(a-z, A-Z)]";
        String notNumberCheck = "[^0-9]";
        String notSpaceCheck = "[^\\s]";
        final int MIN_LENGTH = 3;
        final int MAX_LENGTH = 18;

        Pattern pattern = Pattern.compile(notLetterCheck + notNumberCheck + notSpaceCheck);
        Matcher matcher = pattern.matcher(value);
        final int LENGTH = value.length();
        final boolean RESPECTS_LENGTH_LIMITS = LENGTH >= MIN_LENGTH && LENGTH <= MAX_LENGTH;
        final boolean IS_VALID = !matcher.find() & RESPECTS_LENGTH_LIMITS;
        if (!IS_VALID) {
            throw new InvalidUsernameException();
        }
    }
}