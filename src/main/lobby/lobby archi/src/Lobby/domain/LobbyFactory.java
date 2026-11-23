package Lobby.domain;

public class LobbyFactory {
    public Lobby create(
            String lobbyId,
            int capacity,
            String status) {

        return new Lobby(
                LobbyId.generate(),
                new Capacity(capacity),
                LobbyStatus.STARTED);
    }
}
