package main.player.infra;

public record PlayerPersistenceModel(
        String id,
        String username,
        String password) {}