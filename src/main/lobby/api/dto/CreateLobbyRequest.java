package main.lobby.api.dto;

import jakarta.validation.constraints.NotNull;

public record CreateLobbyRequest (
        @NotNull String lobbyId,
        @NotNull Integer capacity,
        @NotNull String status) {
}
