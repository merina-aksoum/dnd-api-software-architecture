package Lobby.domain;

import java.util.UUID;

public class LobbyFactory {
    public Lobby create(
            String lobbyId,
            int lobbyCapacity) {

        return new Lobby(
                LobbyId.generate()
        );
    }
}
