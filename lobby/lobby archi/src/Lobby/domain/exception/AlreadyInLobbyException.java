package Lobby.domain.exception;

import Lobby.domain.LobbyPlayer;

public class AlreadyInLobbyException extends LobbyException {
    public AlreadyInLobbyException(LobbyPlayer player) {
        super("You are already in the lobby");

    }
}
