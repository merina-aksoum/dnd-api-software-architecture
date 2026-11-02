package Lobby.domain.exception;

import Lobby.domain.Lobby;
import Lobby.domain.LobbyId;

public class LobbyNotFoundException extends LobbyException {
    public LobbyNotFoundException(LobbyId lobbyId) {
        super("Ce " + lobbyId + " n'existe pas.");
    }
}
