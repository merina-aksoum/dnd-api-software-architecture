package Lobby.domain.exception;

public class LobbyFullException extends RuntimeException {
    public LobbyFullException() {
        super("The lobby is full");
    }
}
