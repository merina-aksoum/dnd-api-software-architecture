package main.character.domain.hero.exceptions;

public class InvalidAbilityValueException extends RuntimeException {
    public InvalidAbilityValueException() {
        super("The value given to an ability should be between 3 and 18.");
    }
}
