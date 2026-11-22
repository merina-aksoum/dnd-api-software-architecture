package Lobby.domain;

public record LobbyOverview(
        LobbyId id,
        PlayerId hostId,
        int playerCount,
        Capacity maxPlayers
) {
}

