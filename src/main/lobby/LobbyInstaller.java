package main.lobby;

import main.lobby.api.*;
import main.lobby.application.*;
import main.lobby.domain.LobbyFactory;
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
        LobbyOutputMapper lobbyOutputMapper = new LobbyOutputMapper();
        LobbiesOutputMapper lobbiesOutputMapper = new LobbiesOutputMapper();
        LobbyFactory lobbyFactory = new LobbyFactory();

        CreateLobbyUseCase createLobbyUseCase = new CreateLobbyUseCase(lobbyRepository, lobbyFactory, lobbyOutputMapper);
        GetLobbyUseCase getLobbyUseCase =
                new GetLobbyUseCase(lobbyRepository, lobbyOutputMapper);
        GetLobbiesUseCase getLobbiesUseCase = new GetLobbiesUseCase(lobbyRepository, lobbiesOutputMapper);
        JoinLobbyUseCase joinLobbyUseCase = new JoinLobbyUseCase(lobbyRepository,playerGateway,lobbyOutputMapper);
        LeaveLobbyUseCase leaveLobbyUseCase = new LeaveLobbyUseCase();

        resourceConfig.register(
                new LobbyResource(
                        createLobbyUseCase,
                        new CreateLobbyRequestMapper(),
                        getLobbyUseCase,
                        getLobbiesUseCase,
                        joinLobbyUseCase,
                        leaveLobbyUseCase,
                        new LobbyResponseMapper()
                ));
        resourceConfig.register(new LobbyExceptionMapper());
        resourceConfig.register(new LobbyNotFoundExceptionMapper());
    }


}
