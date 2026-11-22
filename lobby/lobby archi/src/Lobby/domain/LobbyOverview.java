package Lobby.domain;

public record LobbyOverview(
        String id,
        String hostId,
        int playerCount,
        int maxPlayers
) {
}

