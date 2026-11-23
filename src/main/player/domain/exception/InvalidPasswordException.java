package main.player.domain.exception;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException() {
        super("""
                Password format is invalid:
                    * Must be at least 8 characters long
                    * Must contain at least 1 special character
                    * Must contain at least 1 lowercase letter
                    * Must contain at least 1 uppercase letter
                    * Must contain at least 1 digit
                """);
    }
}