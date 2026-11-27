package player.infra;

import player.domain.*;

public class PlayerPersistenceMapper {

    private final Jargon2PasswordHash jargon2PasswordHash = new Jargon2PasswordHash();

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
