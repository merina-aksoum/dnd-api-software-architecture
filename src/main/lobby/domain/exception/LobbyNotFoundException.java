package main.lobby.domain.exception;


import main.lobby.domain.LobbyId;

public class LobbyNotFoundException extends LobbyException {
    public LobbyNotFoundException(LobbyId lobbyId) {
        super("Ce " + lobbyId + " n'existe pas.");
    }
}
