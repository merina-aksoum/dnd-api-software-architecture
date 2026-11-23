package Lobby.application;

import Lobby.domain.Lobby;
import Lobby.domain.LobbyId;
import Lobby.domain.LobbyRepository;

public class JoinLobbyUseCase {
    private final LobbyRepository repository;
    private final LobbyOutputMapper outputMapper;

    public JoinLobbyUseCase(
            LobbyRepository repository,
            LobbyOutputMapper outputMapper) {
        this.repository = repository;
        this.outputMapper = outputMapper;
    }

    public LobbyOutput execute(JoinLobbyCommand command) {
        LobbyId lobbyId = new LobbyId((command.lobbyId()));
        PlayerId playerId = new PlayerId(command.playerId());

        Lobby lobby = repository.fetchById(lobbyId);

        //exception checking

        lobby.join(playerId);
        repository.save(lobby);

        Lobby updated = repository.fetchById(lobbyId);
        return outputMapper.toOutput(updated);
    }
}
