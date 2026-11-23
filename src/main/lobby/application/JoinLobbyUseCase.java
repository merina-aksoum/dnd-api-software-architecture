package main.lobby.application;

import Lobby.domain.Lobby;
import Lobby.domain.LobbyId;
import Lobby.domain.LobbyRepository;
import Lobby.domain.PlayerGateway;

public class JoinLobbyUseCase {
    private final LobbyRepository repository;
    private final PlayerGateway gateway;
    private final LobbyOutputMapper outputMapper;

    public JoinLobbyUseCase(
            LobbyRepository repository,
            PlayerGateway gateway,
            LobbyOutputMapper outputMapper) {
        this.repository = repository;
        this.gateway = gateway;
        this.outputMapper = outputMapper;
    }

    public LobbyOutput execute(JoinLobbyCommand command) {
        LobbyId lobbyId = new LobbyId((command.lobbyId()));
        PlayerId playerId = new PlayerId(command.playerId());

        Lobby lobby = repository.fetchById(lobbyId);

        //exception checking

        LobbyPlayer player = gateway.getLobbyPlayer(playerId);
        lobby.join(player);
        repository.save(lobby);

        Lobby updated = repository.fetchById(lobbyId);
        return outputMapper.toOutput(updated);
    }
}
