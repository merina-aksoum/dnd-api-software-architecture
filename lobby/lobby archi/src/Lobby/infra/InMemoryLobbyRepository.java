package Lobby.infra;

import Lobby.domain.Lobby;
import Lobby.domain.LobbyId;
import Lobby.domain.LobbyRepository;

import java.util.List;
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
    public LobbyPersistenceModel fetchById(LobbyId lobbyId) {
        LobbyPersistenceModel lobby = lobbies.get(lobbyId.value());
        return lobby;
    }

    @Override
    public Map<String, LobbyPersistenceModel> fetchLobbies() {
        return lobbies;
    }
}
