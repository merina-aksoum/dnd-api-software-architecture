package Lobby.domain.exception;

import Lobby.domain.LobbyId;

public class LobbyNotOpenException extends LobbyException {

    public LobbyNotOpenException(LobbyId message) {
        super("Lobby is not open, please try again later.");
    }
}
