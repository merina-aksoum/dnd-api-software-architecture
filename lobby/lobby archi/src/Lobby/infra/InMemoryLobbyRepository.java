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
        Collection<LobbyPersistenceModel> lobbyModels = lobbies.values();
        for (LobbyPersistenceModel model : lobbyModels) {
            if (LobbyStatus.valueOf(model.state()) == LobbyStatus.OPEN) {
                LobbyOverview overview = persistenceMapper.toOverview(model);
                lobbyOverviews.add(overview);
            }
        }
        return lobbyOverviews;
    }

}
