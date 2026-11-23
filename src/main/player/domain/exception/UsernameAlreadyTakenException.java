package main.player.domain.exception;

public class UsernameAlreadyTakenException extends RuntimeException {
    public UsernameAlreadyTakenException() {
        super("This username is already taken.");
    }
}
