package main.player.domain;

import java.util.Objects;

public class Player {
    private Username username;
    private Password password; // TODO: Find a way to make actually secured passwords
    private PlayerId id;

    public Player(
            PlayerId id,
            Username username,
            Password password) {
        this.id = Objects.requireNonNull(id);
        this.username = Objects.requireNonNull(username);
        this.password = Objects.requireNonNull(password);
    }

    public Username getUsername() {
        return username;
    }

    public Password getPassword() {
        return password;
    }

    public PlayerId getId() {
        return id;
    }
}