package Lobby.application;

import Lobby.domain.Lobby;

public class LobbyOutputMapper {
    public LobbyOutput toOutput(Lobby lobby) {
        return new LobbyOutput(
                lobby.lobbyId(),
                lobby.status(),
                lobby.capacity()
        );
    }
}
