package main.player;

import main.player.api.*;
import org.glassfish.jersey.server.ResourceConfig;
import player.api.*;
import main.player.application.PlayerOutputMapper;
import main.player.application.usecase.CreatePlayerUseCase;
import main.player.application.usecase.GetPlayerUseCase;
import main.player.domain.PlayerFactory;
import main.player.domain.PlayerRepository;
import main.player.infra.InMemoryPlayerRepository;
import main.player.infra.PlayerPersistenceMapper;

public class PlayerInstaller {
    private final PlayerRepository playerRepository;

    public PlayerInstaller() {
        this.playerRepository = new InMemoryPlayerRepository(new PlayerPersistenceMapper());;
    }

    public void install(ResourceConfig resourceConfig) {
        PlayerOutputMapper outputMapper = new PlayerOutputMapper();
        CreatePlayerUseCase createPlayerUseCase = new CreatePlayerUseCase(
                new PlayerFactory(), playerRepository, outputMapper
        );
        GetPlayerUseCase getPlayerUseCase = new GetPlayerUseCase(playerRepository, outputMapper);

        resourceConfig.register(
                new PlayerResource(
                        createPlayerUseCase,
                        new CreatePlayerRequestMapper(),
                        getPlayerUseCase,
                        new PlayerResponseMapper()
                )
        );

        resourceConfig.register(new PlayerExceptionMapper());
        resourceConfig.register(new PlayerNotFoundExceptionMapper());
        resourceConfig.register(new InvalidPasswordExceptionMapper());
    }
}