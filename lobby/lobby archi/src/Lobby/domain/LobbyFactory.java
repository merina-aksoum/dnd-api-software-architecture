package Lobby.domain;

import java.util.Objects;

public class LobbyFactory {
    private final Capacity capacity;

    public LobbyFactory() {
        this.capacity = Objects.requireNonNull(capacity);
    }

    public Lobby create(
            String lobbyId,
            int capacity,
            String status,
            LobbyPlayer lobbyHost) {

        return new Lobby(
                LobbyId.generate(),
                new Capacity(capacity),
                LobbyStatus.WAITING);
    }
}
