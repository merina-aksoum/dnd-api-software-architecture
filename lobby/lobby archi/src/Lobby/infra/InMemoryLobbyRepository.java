package Lobby.infra;

import Lobby.domain.*;

import java.util.ArrayList;
import java.util.Collection;
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
        Lobby lobby = persistenceMapper.toDomain(lobbyModel, lobbyPlayers);
        return lobby;
    }

    @Override
    public List<LobbyOverview> fetchLobbies() {
        List<LobbyOverview> lobbyOverviews = new ArrayList<>();
        Collection<LobbyPersistenceModel> lobbyPersistenceModels = lobbies.values();
        for (LobbyPersistenceModel model : lobbyPersistenceModels) {
            lobbyOverviews.add(new LobbyOverview(model.lobbyId(), model.hostId(),  model.capacity() - model.players().size() ,model.capacity()));
        }
        return lobbyOverviews;
    }
}
