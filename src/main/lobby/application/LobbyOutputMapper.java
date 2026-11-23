package main.lobby.application;

import Lobby.domain.Lobby;
import java.util.List;

public class LobbyOutputMapper {
    public LobbyOutput toOutput(Lobby lobby) {
        return new LobbyOutput(
                lobby.lobbyId().value(),
                lobby.status().toString(),
                lobby.players(),
                lobby.capacity().value() - lobby.playerCount()
        );
    }
}
