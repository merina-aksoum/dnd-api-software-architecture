package Lobby.application;

import Lobby.domain.Lobby;
import Lobby.domain.LobbyId;
import Lobby.domain.LobbyOverview;
import Lobby.domain.LobbyRepository;

import java.util.List;

public class GetLobbiesUseCase {
    private final LobbyRepository lobbyRepository;
    private final LobbiesOutputMapper outputMapper;

    public GetLobbiesUseCase(LobbyRepository lobbyRepository,
                           LobbiesOutputMapper outputMapper) {
        this.lobbyRepository = lobbyRepository;
        this.outputMapper = outputMapper;
    }

    public List<LobbiesOutput> execute() {
        List<LobbyOverview> lobbies = lobbyRepository.fetchLobbies();
        return outputMapper.toOutput(lobbies);
    }
}
