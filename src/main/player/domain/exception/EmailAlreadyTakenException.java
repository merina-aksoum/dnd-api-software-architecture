package main.player.domain.exception;

public class EmailAlreadyTakenException extends RuntimeException {
    public EmailAlreadyTakenException() {
        super("This email is already taken.");
    }
}
