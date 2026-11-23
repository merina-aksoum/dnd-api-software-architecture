package main.lobby.domain;

public record LobbyOverview(
        LobbyId id,
        PlayerId hostId,
        int playerCount,
        Capacity maxPlayers
) {
}

