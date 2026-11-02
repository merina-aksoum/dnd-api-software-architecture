package Lobby.application;

import Lobby.domain.Lobby;
import Lobby.domain.LobbyFactory;
import Lobby.domain.LobbyRepository;

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
                command.status());
        lobbyRepository.save(lobby);
        return lobbyOutputMapper.toOutput(lobby);
    }
}
