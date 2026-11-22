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

    public void join(LobbyPlayer player) {
        Objects.requireNonNull(player);
        if (status != LobbyStatus.WAITING) {
            throw new LobbyNotOpenException(lobbyId);
        }
        if (player.contains(player)) {
            throw new AlreadyInLobbyException(player);
        }
        if (player.size() >= capacity.value()) {
            throw new LobbyFullException(lobbyId);
        }
        players.add(player);
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


