package main.player;

import main.player.api.*;
import org.glassfish.jersey.server.ResourceConfig;
import main.player.application.PlayerOutputMapper;
import main.player.application.CreatePlayerUseCase;
import main.player.application.GetPlayerUseCase;
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

        resourceConfig.register(new InvalidRequestExceptionMapper());
        resourceConfig.register(new UsernameAlreadyTakenExceptionMapper());
        resourceConfig.register(new EmailAlreadyTakenExceptionMapper());
        resourceConfig.register(new PasswordTooShortExceptionMapper());
        resourceConfig.register(new PlayerNotFoundExceptionMapper());
    }
}