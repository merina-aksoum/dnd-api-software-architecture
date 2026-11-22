package Lobby.domain;

import java.util.Queue;

public class LobbyHost {
    ArrayList<Player> playerList = new ArrayList<Player>();

    public void add(LobbyPlayer player) {
        Objects.requireNonNull(player);

    }
}
