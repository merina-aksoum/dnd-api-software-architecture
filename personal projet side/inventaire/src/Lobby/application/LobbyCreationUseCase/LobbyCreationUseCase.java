package Lobby.application.LobbyCreationUseCase;

import Lobby.application.port.LobbyRepository;
import Lobby.domain.LobbyFactory;

public class LobbyCreationUseCase {
    private final LobbyRepository lobbyRepository;

    public LobbyCreationUseCase(LobbyRepository lobbyRepository) {
        this.lobbyRepository = lobbyRepository;
    }

    public void execute(LobbyCreationCommand lobbyCreationCommand) {
        LobbyFactory LobbyFactory = new LobbyFactory();
        // Need to make a method to check the repository if it already exists
    }
}
