package Lobby.application;

public record LobbyOutput (
        String lobbyId,
        String state,
        List<PlayerRepresentation> players,
        int availableSeats) {
}
