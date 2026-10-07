package Lobby.application.LobbyCreationUseCase;

import Lobby.application.port.LobbyRepository;
import Lobby.domain.Lobby;
import Lobby.domain.LobbyCapacity;
import Lobby.domain.LobbyFactory;

public class LobbyCreationUseCase {
    private final LobbyRepository lobbyRepository;
    private final LobbyFactory lobbyFactory;
    private final LobbyOutputMapper lobbyOutputMapper;

    public LobbyCreationUseCase(LobbyRepository lobbyRepository, LobbyFactory lobbyFactory, LobbyFactory lobbyFactory1, LobbyOutputMapper lobbyOutputMapper) {
        this.lobbyRepository = lobbyRepository;
        this.lobbyFactory = lobbyFactory;
        this.lobbyOutputMapper = lobbyOutputMapper;
    }

    public LobbyOutput execute(LobbyCreationCommand command) {
        Lobby lobby = lobbyFactory.create(
                command.lobbyId(),
                command.lobbyCapacity());
        LobbyRepository.save(lobby);
    }
}
