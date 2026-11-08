package main.player.api.dto;

public record GetPlayerResponse (
        String id,
        String username,
        String password,
        String email
) {}