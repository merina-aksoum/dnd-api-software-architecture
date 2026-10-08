package player.domain.exception;

public class InvalidPasswordException extends PlayerException {
    public InvalidPasswordException() {
        super("Password is invalid");
    }
}
