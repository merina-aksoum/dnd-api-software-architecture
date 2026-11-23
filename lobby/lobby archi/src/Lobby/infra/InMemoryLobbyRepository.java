package Lobby.infra;

import Lobby.domain.Lobby;
import Lobby.domain.LobbyId;
import Lobby.domain.LobbyRepository;
import Lobby.domain.exception.LobbyNotFoundException;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryLobbyRepository implements LobbyRepository {
    private final Map<String, LobbyPersistenceModel> lobbies = new ConcurrentHashMap<>();
    private final LobbyPersistenceMapper persistenceMapper;

    public InMemoryLobbyRepository(LobbyPersistenceMapper persistenceMapper) {
        this.persistenceMapper = persistenceMapper;
    }


    @Override
    public void save(Lobby lobby) {
        LobbyPersistenceModel model = persistenceMapper.toPersistence(lobby);
        lobbies.put(model.lobbyId(), model);
    }

    @Override
    public Lobby fetchById(LobbyId lobbyId) {
        LobbyPersistenceModel model = lobbies.get(lobbyId.value());
        if (model == null) {
            throw new LobbyNotFoundException(lobbyId);
        }
        return persistenceMapper.toDomain(model);
    }

    @Override
    public Optional<Lobby> findById(LobbyId lobbyId) {
        return Optional.empty();
    }

    @Override
    public Optional<Lobby> findByName(String name) {
        return Optional.empty();
    }
}
