package main.player.domain.exception;

public class PasswordTooShortException extends PlayerException {
    public PasswordTooShortException(int length) {
        super(String.format("Password is too short, must be at least 8 characters long (currently: %d)\n", length));
    }
}
