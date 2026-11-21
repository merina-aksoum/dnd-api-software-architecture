package Lobby.infra;

import Lobby.domain.Capacity;
import Lobby.domain.Lobby;
import Lobby.domain.LobbyId;
import Lobby.domain.LobbyStatus;

public class LobbyPersistenceMapper {
    public LobbyPersistenceModel toPersistence(Lobby lobby) {
        return new LobbyPersistenceModel(
                lobby.lobbyId().value(),
                lobby.status().toString(),
                lobby.hostId().value(),
                lobby.players(),
                lobby.capacity());
    }

    public Lobby toDomain(LobbyPersistenceModel model) {
        return new Lobby(
                new LobbyId(model.lobbyId()),
                LobbyStatus.valueOf(model.state()),
                new PlayerId(model.hostId()),
                new Capacity(model.capacity()),
                new List<PlayerId>(model.players())
        );
    }
}
