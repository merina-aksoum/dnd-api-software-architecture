package Lobby.application;

import Lobby.domain.Lobby;
import Lobby.domain.LobbyId;
import Lobby.domain.LobbyRepository;
import Lobby.domain.PlayerGateway;

public class LeaveLobbyUseCase {

    private final LobbyRepository repository;

    public void execute(LeaveLobbyCommand command) {

        LobbyId lobbyId = new LobbyId(command.lobbyId());
        PlayerId playerId = new PlayerId(command.playerId());
        PlayerId connectedPlayerId = new PlayerId(command.connectedPlayerId());

        //exception checking

        Lobby lobby = repository.fetchById(lobbyId);
        lobby.leave(playerId);
        repository.save(lobby);
    }
}
