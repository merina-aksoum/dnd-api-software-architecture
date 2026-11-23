package Lobby.application;

import Lobby.domain.Lobby;
import Lobby.domain.LobbyFactory;
import Lobby.domain.LobbyPlayer;
import Lobby.domain.LobbyRepository;
import Lobby.domain.exception.AlreadyInLobbyException;

public class CreateLobbyUseCase {
    private final LobbyRepository lobbyRepository;
    private final LobbyFactory lobbyFactory;
    private final LobbyOutputMapper lobbyOutputMapper;

    public CreateLobbyUseCase(LobbyRepository lobbyRepository,
                              LobbyFactory lobbyFactory,
                              LobbyOutputMapper lobbyOutputMapper) {
        this.lobbyRepository = lobbyRepository;
        this.lobbyFactory = lobbyFactory;
        this.lobbyOutputMapper = lobbyOutputMapper;
    }

    public LobbyOutput execute(CreateLobbyCommand command) {
        Lobby lobby = lobbyFactory.create(
                command.lobbyId(),
                command.lobbyCapacity(),
                command.status(),
                command.lobbyHost());
        lobbyRepository.save(lobby);
        LobbyPlayer lobbyHost = new LobbyPlayer(command.playerId(), command.playerName(), false);

        if (lobbyRepository.findWaitingLobbyOf(lobbyHost.id().isPresent())) {
            throw new AlreadyInLobbyException(lobbyHost.id());
        }
        return lobbyOutputMapper.toOutput(lobby);
    }
}
