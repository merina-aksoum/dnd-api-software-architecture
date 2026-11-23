package main.lobby.api.dto;

import main.lobby.domain.LobbyPlayer;

import java.util.List;

public record GetLobbyResponse(
        String lobbyId,
        String state,
        List<LobbyPlayer> players,
        int availableSeats) {
}
