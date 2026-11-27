package player.infra;

public record PlayerPersistenceModel(
        String username,
        String password,
        String email) {}