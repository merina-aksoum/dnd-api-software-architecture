package main.lobby.infra;

import main.player.domain.PlayerId;

import java.util.List;

public record LobbyPersistenceModel(
        String lobbyId,
        String state,
        String hostId,
        List<PlayerId> players,
        int capacity) {

}