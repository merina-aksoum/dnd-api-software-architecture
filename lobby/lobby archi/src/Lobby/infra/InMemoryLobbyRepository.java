package Lobby.infra;

import Lobby.domain.Lobby;
import Lobby.domain.LobbyId;
import Lobby.domain.LobbyRepository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryLobbyRepository implements LobbyRepository {
    private final Map<String, LobbyPersistenceModel> lobbies = new ConcurrentHashMap<>()

    @Override
    public void save(Lobby lobby) {
    }

    @Override
    public Lobby fetchById(LobbyId lobbyId) {
        return null;
    }
}
