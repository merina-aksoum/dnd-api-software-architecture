package main.player.domain.exception;

public class InvalidEmailException extends PlayerException {
    public InvalidEmailException(String value) {
        super(String.format("Email %s is invalid", value));
    }
}
