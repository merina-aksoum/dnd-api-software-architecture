package Lobby.application;

public record JoinLobbyCommand(
        String lobbyId,
        String playerId
) {
}
