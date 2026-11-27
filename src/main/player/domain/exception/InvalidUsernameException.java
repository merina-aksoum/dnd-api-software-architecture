package player.domain.exception;

public class InvalidUsernameException extends PlayerException {
    public InvalidUsernameException(String username) {
        super(String.format("Username %s is invalid. A username can only contain letters, numbers and underscores", username));
    }
}