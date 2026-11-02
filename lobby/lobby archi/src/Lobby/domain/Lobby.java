package Lobby.domain;

import java.util.Objects;

public class Lobby {
    private final LobbyId lobbyId;
    private final Capacity capacity;
    private final LobbyStatus status;

    public Lobby(LobbyId lobbyId,
                 Capacity capacity,
                 LobbyStatus status) {
        this.lobbyId = Objects.requireNonNull(lobbyId);
        this.capacity = Objects.requireNonNull(capacity);
        this.status = Objects.requireNonNull(status);
    }

    public LobbyId lobbyId() {
        return lobbyId;
    }
    public Capacity capacity() {
        return capacity;
    }
    public LobbyStatus status() {
        return status;
    }
    @Override
    public boolean equals(Object o) {
        return o instanceof Lobby lobby && lobbyId.equals(lobbyId);
    }
    @Override
    public int hashCode() {
        return lobbyId.hashCode();
    }
}


