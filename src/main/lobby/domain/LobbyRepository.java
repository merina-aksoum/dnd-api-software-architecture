package main.lobby.domain;

import java.util.List;

public interface LobbyRepository {
    void save(Lobby lobby);

    Lobby fetchById(LobbyId lobbyId);

    List<LobbyOverview> fetchLobbies();
}
