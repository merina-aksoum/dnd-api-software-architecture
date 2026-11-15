package Lobby.infra;

public record LobbyPersistenceModel(
        String lobbyId,
        String state,
        String hostId,
        List<PlayerPersistenceModel> players,
        int capacity) {

}