package main.lobby.infra;


import main.lobby.domain.*;
import main.lobby.domain.Lobby.*;
import main.player.domain.PlayerId;
import java.util.List;

public class LobbyPersistenceMapper {
    public LobbyPersistenceModel toPersistence(Lobby lobby) {
        return new LobbyPersistenceModel(
                lobby.lobbyId().value(),
                lobby.status().toString(),
                lobby.hostId().value(),
                lobby.players(),
                lobby.capacity().value());
    }

    public Lobby toDomain(LobbyPersistenceModel model, List<LobbyPlayer> players) {
        return new Lobby(
                new LobbyId(model.lobbyId()),
                LobbyStatus.valueOf(model.state()),
                new PlayerId(model.hostId()),
                new Capacity(model.capacity()),
                players
        );
    }

    public LobbyOverview toOverview(LobbyPersistenceModel model) {
        return new LobbyOverview(
                new LobbyId(model.lobbyId()),
                new PlayerId(model.hostId()),
                model.capacity() - model.players().size(),
                new Capacity(model.capacity())
        );
    }
}
