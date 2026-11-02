package Lobby.domain;

public interface LobbyRepository {
    void save(Lobby lobby);

    Lobby fetchById(LobbyId lobbyId);
}
