package main.lobby.application;

import main.lobby.domain.LobbyPlayer;

import java.util.List;

public record LobbyOutput (
        String lobbyId,
        String state,
        List<LobbyPlayer> players,
        int availableSeats) {
}
