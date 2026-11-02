package Lobby.application;

import Lobby.domain.Lobby;
import Lobby.domain.LobbyId;
import Lobby.domain.LobbyRepository;

public class GetLobbyUseCase {
    private final LobbyRepository lobbyRepository;
    private final LobbyOutputMapper outputMapper;

    public GetLobbyUseCase(LobbyRepository lobbyRepository,
                           LobbyOutputMapper outputMapper) {
        this.lobbyRepository = lobbyRepository;
        this.outputMapper = outputMapper;
    }

    public LobbyOutput execute(GetLobbyQuery query) {
        LobbyId lobbyId = new LobbyId(query.lobbyId());

        Lobby lobby = lobbyRepository.fetchById(lobbyId);

        return outputMapper.toOutput(lobby);
    }
}
