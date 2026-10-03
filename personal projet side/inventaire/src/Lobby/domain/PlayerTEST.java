package Lobby.domain;

import java.util.UUID;

public class PlayerTEST {
    private final UUID id;
    private final String name;

    public PlayerTEST(UUID id, String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
