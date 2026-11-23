package main.player.infra;

import main.player.domain.*;

public class PlayerPersistenceMapper {
    public PlayerPersistenceModel toPersistence(Player player) {
        return new PlayerPersistenceModel(
                player.getId().value(),
                player.getUsername().value(),
                player.getPassword().value(),
                player.getEmail().value()
        );
    }

    public Player toDomain(PlayerPersistenceModel model) {
        return new Player(
                new PlayerId(model.id()),
                new Username(model.username()),
                new Password(model.password()),
                new Email(model.email()));
    }
}
