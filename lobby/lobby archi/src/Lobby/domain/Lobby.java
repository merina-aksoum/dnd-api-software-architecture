package Lobby.domain;

import java.util.Objects;
import java.util.List;


public class Lobby {
    private final LobbyId lobbyId;
    private final LobbyStatus status;
    private final PlayerId hostId;
    private final Capacity capacity;
    private final List<LobbyPlayer> players;

    public Lobby(LobbyId lobbyId,
                 LobbyStatus status,
                 PlayerId hostId,
                 Capacity capacity,
                 List<LobbyPlayer> players) {
        this.lobbyId = Objects.requireNonNull(lobbyId);
        this.status = Objects.requireNonNull(status);
        this.hostId = hostId;
        this.capacity = Objects.requireNonNull(capacity);
        this.players = players;
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
    public List<LobbyPlayer> players() { return players;}
    public int playerCount() { return players.size();}
    public PlayerId hostId() {return hostId;}
    @Override
    public boolean equals(Object o) {
        return o instanceof Lobby lobby && lobbyId.equals(lobbyId);
    }
    @Override
    public int hashCode() {
        return lobbyId.hashCode();
    }

    public void join(LobbyPlayer player) {
        players.add(player);
    }
}


