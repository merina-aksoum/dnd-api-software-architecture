package Lobby.api.dto;

import Lobby.application.CreateLobbyCommand;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CreateLobbyRequest (
        @NotNull String lobbyId,
        @NotNull Integer capacity,
        @NotNull String status) {


}
