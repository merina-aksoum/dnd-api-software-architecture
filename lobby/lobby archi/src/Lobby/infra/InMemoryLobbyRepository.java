package Lobby.infra;

import Lobby.domain.Lobby;
import Lobby.domain.LobbyId;
import Lobby.domain.LobbyRepository;
import Lobby.domain.PlayerGateway;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryLobbyRepository implements LobbyRepository {

    private final Map<String, LobbyPersistenceModel> lobbies = new ConcurrentHashMap<>();
    private final PlayerGateway playerGateway;
    private final LobbyPersistenceMapper persistenceMapper;


    public InMemoryLobbyRepository(LobbyPersistenceMapper persistenceMapper, PlayerGateway playerGateway) {
        this.persistenceMapper = persistenceMapper;
        this.playerGateway = playerGateway;
    }
    @Override
    public void save(Lobby lobby) {
    }

    @Override
    public Lobby fetchById(LobbyId lobbyId) {
        LobbyPersistenceModel lobbyModel = lobbies.get(lobbyId.value());
        List<LobbyPlayer> lobbyPlayers = playerGateway.getLobbyPlayers(lobbyModel.players());
        Lobby lobby = persistenceMapper.toDomain(lobbyModel, playerOverviews);
        return lobby;
    }

    @Override
    public List<LobbyOverivew> fetchLobbies() {
        return lobbies;
    }
}
