package Lobby.application;

import java.util.List;

public record LobbyOutput (
        String lobbyId,
        String state,
        List<LobbyPlayer> players,
        int availableSeats) {
}
