package Lobby.infra;

import java.util.List;

public record LobbyPersistenceModel(
        String lobbyId,
        String state,
        String hostId,
        List<PlayerId> players,
        int capacity) {

}