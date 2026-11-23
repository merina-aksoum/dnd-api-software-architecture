package Lobby.application;

public record LeaveLobbyCommand(
        String lobbyId,
        String playerId,
        String connectedPlayerId
) {

}
