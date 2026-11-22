package Lobby.infra;

import Lobby.domain.Capacity;
import Lobby.domain.Lobby;
import Lobby.domain.LobbyId;
import Lobby.domain.LobbyStatus;

public class LobbyPersistenceMapper {
    public LobbyPersistenceModel toPersistence(Lobby lobby) {
        return new LobbyPersistenceModel(
                lobby.lobbyId().value(),
                lobby.capacity().value(),
                lobby.status().toString()); // Figure out the issue with ENUM, maybe try another way to get the status of the game.
    }

    public Lobby toDomain(LobbyPersistenceModel model) {
        return new Lobby(
                new LobbyId(model.lobbyId()),
                new Capacity(model.capacity()),
                LobbyStatus.valueOf(model.status())
        );
    }
}
