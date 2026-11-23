package main.player.domain.exception;

public class EmptyFieldException extends InvalidRequestException {
    public EmptyFieldException(String fieldName) {
        super(String.format("The %s field should not be left empty.", fieldName));
    }
}
