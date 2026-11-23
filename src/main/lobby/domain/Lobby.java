package main.lobby.domain;

import main.player.domain.PlayerId;

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

    public LobbyId lobbyId() { return lobbyId; }
    public LobbyStatus status() { return status; }
    public PlayerId hostId() { return hostId;}
    public Capacity capacity() { return capacity; }
    public List<LobbyPlayer> players() { return players; }
    public int playerCount() { return players.size();}
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

    public void leave(PlayerId playerId) { //complete with actual lobbyplayer representation
        for (LobbyPlayer player : players) {
            if (player.id().equals(playerId.value())) {
                players.remove(player);
            }
        }
    }
}


