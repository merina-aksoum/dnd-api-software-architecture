package player.domain.exception;

public abstract class PlayerException extends RuntimeException {
    protected PlayerException(String message) {
        super(message);
    }
}
