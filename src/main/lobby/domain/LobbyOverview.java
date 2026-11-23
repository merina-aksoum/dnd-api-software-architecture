package main.lobby.domain;

import main.player.domain.PlayerId;

public record LobbyOverview(
        LobbyId id,
        PlayerId hostId,
        int playerCount,
        Capacity maxPlayers
) {
}

