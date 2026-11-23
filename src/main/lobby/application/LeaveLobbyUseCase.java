package main.lobby.application;


import main.lobby.domain.Lobby;
import main.lobby.domain.LobbyId;
import main.lobby.domain.LobbyRepository;
import main.player.domain.PlayerId;

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
