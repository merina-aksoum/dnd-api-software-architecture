package Lobby.application.Exception;

public class AlreadyInLobbyException extends RuntimeException {
    public AlreadyInLobbyException(String message) {
        super(message);
    }
}
