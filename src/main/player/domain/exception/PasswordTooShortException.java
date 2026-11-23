package main.player.domain.exception;

public class PasswordTooShortException extends RuntimeException {
    public PasswordTooShortException() {
        super("Password is too short.");
    }
}
