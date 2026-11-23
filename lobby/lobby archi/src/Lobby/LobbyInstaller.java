package Lobby;
import Lobby.api.*;
import Lobby.application.CreateLobbyUseCase;
import Lobby.application.GetLobbyUseCase;
import Lobby.application.LobbyOutputMapper;
import Lobby.domain.LobbyFactory;
import Lobby.domain.LobbyRepository;
import Lobby.infra.InMemoryLobbyRepository;
import Lobby.infra.LobbyPersistenceMapper;
import org.glassfish.jersey.server.ResourceConfig;

public class LobbyInstaller {
        private final LobbyRepository lobbyRepository;

        public LobbyInstaller() {
            this.lobbyRepository =
                    new InMemoryLobbyRepository(new LobbyPersistenceMapper());
        }

        public void install(ResourceConfig resourceConfig) {
            LobbyOutputMapper outputMapper = new LobbyOutputMapper();
            LobbyFactory lobbyFactory = new LobbyFactory();

            CreateLobbyUseCase createRestaurantUseCase =
                    new CreateLobbyUseCase(
                            lobbyRepository, new LobbyFactory(), outputMapper);
            GetLobbyUseCase getRestaurantUseCase =
                    new GetLobbyUseCase(lobbyRepository, outputMapper);
            resourceConfig.register(
                    new LobbyResource(
                            createRestaurantUseCase,
                            new CreateLobbyRequestMapper(),
                            getRestaurantUseCase,
                            new LobbyResponseMapper()));
            resourceConfig.register(new LobbyExceptionMapper());
            resourceConfig.register(new LobbyNotFoundExceptionMapper());
        }
    }


