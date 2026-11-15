package Lobby.infra;

import Lobby.domain.Lobby;
import Lobby.domain.LobbyId;
import Lobby.domain.LobbyRepository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryLobbyRepository implements LobbyRepository {

    private final Map<String, LobbyPersistenceModel> lobbies = new ConcurrentHashMap<>();
    private final LobbyPersistenceMapper persistenceMapper;


    public InMemoryLobbyRepository(LobbyPersistenceMapper persistenceMapper) {
        this.persistenceMapper = persistenceMapper;
    }
    @Override
    public void save(Lobby lobby) {
    }

    @Override
    public Lobby fetchById(LobbyId lobbyId) {
        LobbyPersistenceModel lobby = lobbies.get(lobbyId.value());
        return persistenceMapper.toDomain(lobby);
    }
}
