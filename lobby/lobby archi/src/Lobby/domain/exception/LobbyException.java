package Lobby.domain.exception;

public abstract class LobbyException extends RuntimeException {

    public LobbyException(String message) {
        super(message);
    }
}
