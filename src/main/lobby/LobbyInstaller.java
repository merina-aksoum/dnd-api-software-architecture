package main.lobby;

import main.lobby.domain.LobbyRepository;
import main.lobby.domain.PlayerGateway;
import main.lobby.infra.InMemoryLobbyRepository;
import main.lobby.infra.InProcessPlayerGateway;
import main.lobby.infra.LobbyPersistenceMapper;
import main.player.application.GetPlayerUseCase;
import main.player.application.GetPlayersUseCase;
import org.glassfish.jersey.server.ResourceConfig;

public class LobbyInstaller {

    private final GetPlayerUseCase getPlayerUseCase;
    private final GetPlayersUseCase getPlayersUseCase;

    public LobbyInstaller(GetPlayerUseCase getPlayerUseCase, GetPlayersUseCase getPlayersUseCase) {
        this.getPlayersUseCase = getPlayersUseCase;
        this.getPlayerUseCase = getPlayerUseCase;
    }

    public void install(ResourceConfig resourceConfig) {
        PlayerGateway playerGateway = new InProcessPlayerGateway(getPlayersUseCase, getPlayerUseCase);
        LobbyRepository lobbyRepository = new InMemoryLobbyRepository(new LobbyPersistenceMapper(), playerGateway);
    }


}
