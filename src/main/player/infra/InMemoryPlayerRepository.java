package player.infra;

import player.domain.Email;
import player.domain.Player;
import player.domain.PlayerRepository;
import player.domain.Username;
import player.domain.exception.EmailAlreadyUsedException;
import player.domain.exception.PlayerNotFoundException;
import player.domain.exception.UsernameAlreadyUsedException;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryPlayerRepository implements PlayerRepository {
    private final Map<String, PlayerPersistenceModel> players = new ConcurrentHashMap<>();
    private final PlayerPersistenceMapper persistenceMapper;

    public InMemoryPlayerRepository(PlayerPersistenceMapper persistenceMapper) {
        this.persistenceMapper = persistenceMapper;
    }

    @Override
    public void save(Player player) {
        PlayerPersistenceModel model = persistenceMapper.toPersistence(player);
        players.put(model.username(), model);
    }

    @Override
    public Player fetchByUsername(Username username) {
        PlayerPersistenceModel model = players.get(username.value());
        if (model == null) {
            throw new PlayerNotFoundException(username);
        }
        return persistenceMapper.toDomain(model);
    }

    @Override
    public boolean isUsed(Email email, Username username) {
        for (PlayerPersistenceModel player : players.values()) {
            if (Objects.equals(player.email(), email.value())) {
                throw new EmailAlreadyUsedException(email);
            }
            if (Objects.equals(player.username(), username.value())) {
                throw new UsernameAlreadyUsedException(username);
            }
        }
        return false;
    }
}
