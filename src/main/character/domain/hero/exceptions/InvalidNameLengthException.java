package main.character.domain.hero.exceptions;

public class InvalidNameLengthException extends RuntimeException {
    public InvalidNameLengthException() {
        super("The name should have between 2 and 30 characters");
    }
}
