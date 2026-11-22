package Lobby.domain;

import Lobby.infra.LobbyPersistenceModel;

import java.util.Map;

public interface LobbyRepository {
    void save(Lobby lobby);

    Lobby fetchById(LobbyId lobbyId);

    Map<String, LobbyPersistenceModel> fetchLobbies();
}
