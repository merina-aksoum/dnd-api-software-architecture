package main.lobby.application;

public record JoinLobbyCommand(
        String lobbyId,
        String playerId
) {
}
