package Lobby.domain;

import java.util.Objects;

public class LobbyPlayer {
    private final String id;
    private final String username;

    public LobbyPlayer(String id, String name) {
        this.id = Objects.requireNonNull(id, "Lobby player id must not be null");
        this.username = Objects.requireNonNull(name, "Lobby player name must not be null");
    }

    public String id() {
        return id;
    }
    public String name() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
      return o instanceof LobbyPlayer && this.id.equals(((LobbyPlayer) o).id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}