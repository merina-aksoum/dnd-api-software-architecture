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
                lobby.status().value());
    }

    public Lobby toDomain(LobbyPersistenceModel lobbyPersistenceModel) {
        return new Lobby(
                new LobbyId(model.lobbyId()),
                new Capacity(model.capacity()),
                new LobbyStatus(model.status())
        );
    }
}
