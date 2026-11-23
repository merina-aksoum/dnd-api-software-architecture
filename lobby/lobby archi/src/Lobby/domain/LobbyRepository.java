package Lobby.domain;

import java.util.Optional;

public interface LobbyRepository {
    LobbyId nextLobbyId();
    void save(Lobby lobby);
    Lobby fetchById(LobbyId lobbyId);
    Optional<Lobby> findById(LobbyId lobbyId);
    Optional<Lobby> findByName(String username);
}
