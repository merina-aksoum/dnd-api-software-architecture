package main.character.domain.hero.exceptions;

public class InvalidNameFormatException extends RuntimeException {
    public InvalidNameFormatException() {
        super("The name should only contain letters and spaces.");
    }
}
