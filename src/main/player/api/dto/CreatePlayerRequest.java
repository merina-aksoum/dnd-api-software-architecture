package main.player.api.dto;

import jakarta.validation.constraints.NotNull;

public record CreatePlayerRequest(
                @NotNull String id,
                @NotNull String username,
                @NotNull String password,
                @NotNull String email) {
}