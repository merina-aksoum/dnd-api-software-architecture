package main.lobby.application;

public record LeaveLobbyCommand(
        String lobbyId,
        String playerId,
        String connectedPlayerId
) {

}
