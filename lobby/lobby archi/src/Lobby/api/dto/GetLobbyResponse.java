package Lobby.api.dto;

public record GetLobbyResponse(
        String lobbyId,
        int capacity,
        String status) {
}
