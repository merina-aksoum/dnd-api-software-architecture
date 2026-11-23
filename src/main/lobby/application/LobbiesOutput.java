package main.lobby.application;

public record LobbiesOutput(
        String id,
        String hostId,
        int playerCount,
        int maxPlayers
) {
}
