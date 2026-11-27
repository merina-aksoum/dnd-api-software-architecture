package player.api.dto;

public record GetPlayerResponse (
        String username,
        String email
) {}