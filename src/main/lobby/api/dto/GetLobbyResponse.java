package main.lobby.api.dto;

import java.util.List;

public record GetLobbyResponse(
        String lobbyId,
        String state,
        List<LobbyPlayer> players,
        int availableSeats) {
}
