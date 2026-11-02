package Lobby.infra;

public record LobbyPersistenceModel(
        String lobbyId,
        int capacity,
        String status) {

}