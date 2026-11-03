package main.player.infra;

import main.player.domain.Password;
import main.player.domain.Player;
import main.player.domain.PlayerId;
import main.player.domain.Username;

public class PlayerPersistenceMapper {
    public PlayerPersistenceModel toPersistence(Player player) {
        return new PlayerPersistenceModel(
                player.getId().value(),
                player.getUsername().value(),
                player.getPassword().value()
        );
    }

    public Player toDomain(PlayerPersistenceModel model) {
        return new Player(
                new PlayerId(model.id()),
                new Username(model.username()),
                new Password(model.password())
        );
    }
}
