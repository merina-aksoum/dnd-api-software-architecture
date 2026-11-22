package Lobby.domain.exception;

public class InvalidCapacityException extends LobbyException {
    public InvalidCapacityException() {
        super("This lobby is full, please join another lobby or try again later.");

    }
}
