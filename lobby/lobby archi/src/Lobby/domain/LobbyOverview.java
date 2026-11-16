package Lobby.domain;

public class LobbyOverview {
    private LobbyId id;
    private PlayerId hostId;
    private int playerCount;
    private Capacity maxPlayers;

    public LobbyOverview(Lobby lobby) {
        this.id = lobby.lobbyId();
        this.hostId = lobby.hostId();
        this.playerCount = lobby.capacity().value() - lobby.playerCount();
        this.maxPlayers = lobby.capacity();
    }
}
