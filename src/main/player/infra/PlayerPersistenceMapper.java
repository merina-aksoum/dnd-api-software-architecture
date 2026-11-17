package main.player.infra;

import main.player.domain.*;

public class PlayerPersistenceMapper {

    private final PasswordHash passwordHash = new PasswordHash();

    public PlayerPersistenceModel toPersistence(Player player) {
        return new PlayerPersistenceModel(
                player.getUsername().value(),
                player.getPassword().value(),
                player.getEmail().value()
        );
    }

    public Player toDomain(PlayerPersistenceModel model) {
        return new Player(
                new Username(model.username()),
                new Password(model.password()),
                new Email(model.email()));
    }
}
