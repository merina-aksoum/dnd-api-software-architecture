package Lobby.domain;

public class Lobby {
    private final LobbyId lobbyId;
    private final LobbyCapacity lobbyCapacity;

    public Lobby(LobbyId lobbyId, LobbyCapacity lobbyCapacity) {
        this.lobbyId = lobbyId;
        this.lobbyCapacity = lobbyCapacity;
    }

    public LobbyId getLobbyId() {
        return lobbyId;
    }

    public LobbyCapacity getLobbyCapacity() {
        return lobbyCapacity;
    }
}


