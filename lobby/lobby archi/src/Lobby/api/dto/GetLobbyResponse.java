package Lobby.api.dto;

public record GetLobbyResponse(
        String lobbyId,
        String state,
        List<PlayerRepresentation> players,
        int availableSeats) {
}
