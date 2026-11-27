package player;

import player.api.*;
import player.api.UsernameAlreadyTakenExceptionMapper;
import player.application.PlayerOutputMapper;
import player.application.usecase.CreatePlayerUseCase;
import player.application.usecase.GetPlayerUseCase;
import player.domain.PlayerFactory;
import player.domain.PlayerRepository;
import player.infra.InMemoryPlayerRepository;
import player.infra.PlayerPersistenceMapper;
import org.glassfish.jersey.server.ResourceConfig;

public class PlayerInstaller {
    private final PlayerRepository playerRepository;

    public PlayerInstaller() {
        this.playerRepository = new InMemoryPlayerRepository(new PlayerPersistenceMapper());
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
        resourceConfig.register(new InvalidEmailExceptionMapper());
        resourceConfig.register(new PasswordTooShortExceptionMapper());
        resourceConfig.register(new UsernameAlreadyTakenExceptionMapper());
        resourceConfig.register(new EmailAlreadyUsedExceptionMapper());
    }
}