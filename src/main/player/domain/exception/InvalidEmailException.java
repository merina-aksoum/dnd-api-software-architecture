package main.player.domain.exception;

public class InvalidEmailException extends InvalidRequestException {
    public InvalidEmailException(String value) {
        super(String.format("Email %s format is invalid", value));
    }
}
