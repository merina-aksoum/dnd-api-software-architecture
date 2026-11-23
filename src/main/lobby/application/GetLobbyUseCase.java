package main.lobby.application;

import main.lobby.domain.Lobby;
import main.lobby.domain.LobbyId;
import main.lobby.domain.LobbyRepository;

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
