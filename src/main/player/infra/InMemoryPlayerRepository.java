package main.player.infra;

import main.player.domain.Player;
import main.player.domain.PlayerId;
import main.player.domain.PlayerRepository;
import main.player.domain.exception.PlayerNotFoundException;

import java.util.Map;
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
        players.put(model.id(), model);
    }

    @Override
    public Player fetchById(PlayerId id) {
        PlayerPersistenceModel model = players.get(id.value());
        if (model == null) {
            throw new PlayerNotFoundException(id);
        }
        return persistenceMapper.toDomain(model);
    }
}
