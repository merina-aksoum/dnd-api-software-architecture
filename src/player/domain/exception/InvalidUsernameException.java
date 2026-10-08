package player.domain.exception;

public class InvalidUsernameException extends PlayerException {
    public InvalidUsernameException() {
        super("Username is invalid");
    }
}
