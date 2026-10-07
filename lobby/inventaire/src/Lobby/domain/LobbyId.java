package Lobby.domain;

import java.util.Objects;
import java.util.UUID;

public record LobbyId (String id){
    public LobbyId {
        Objects.requireNonNull(id);
    }

    public static LobbyId generate() {
        return new LobbyId((UUID.randomUUID().toString()));
    }
}
