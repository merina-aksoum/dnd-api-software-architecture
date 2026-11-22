package Lobby.application;

import java.util.List;

import Lobby.domain.Lobby;
import Lobby.domain.LobbyId;
import Lobby.domain.LobbyRepository;
import Lobby.domain.PlayerGateway;
import Lobby.infra.LobbyPersistenceModel;

public class GetLobbyUseCase {
    private final LobbyRepository lobbyRepository;
    private final PlayerGateway playerGateway;
    private final LobbyOutputMapper outputMapper;

    public GetLobbyUseCase(LobbyRepository lobbyRepository,
                           PlayerGateway playerGateway,
                           LobbyOutputMapper outputMapper) {
        this.lobbyRepository = lobbyRepository;
        this.playerGateway = playerGateway;
        this.outputMapper = outputMapper;
    }

    public LobbyOutput execute(GetLobbyQuery query) {
        LobbyId lobbyId = new LobbyId(query.lobbyId());

        LobbyPersistenceModel lobbyModel = lobbyRepository.fetchById(lobbyId);
        // playergateway -> retourne la liste de lobbyplayer
        List<PlayerOverview> playerOverviews = playerGateway.getPlayerOverviews(lobbyModel.players());
        Lobby lobby =



        return outputMapper.toOutput(lobby);
    }
}
