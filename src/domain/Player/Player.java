package domain.player;

import java.util.UUID;

public class Player {
    private String username; // TODO: Get client's requirements for usernames requirement
    private String password;
    private UUID id;

    public Player(
            String username,
            String password) {
        this.username = username;
        this.password = password;
        this.id = UUID.randomUUID();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UUID getId() {
        return id;
    }
}