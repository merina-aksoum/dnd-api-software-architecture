package main.player.domain;

import java.util.Objects;

public class Player {
    private Username username;
    private Password password;
    private PlayerId id;
    private Email email;

    public Player(
            PlayerId id,
            Username username,
            Password password, Email email) {
        this.id = Objects.requireNonNull(id);
        this.username = Objects.requireNonNull(username);
        this.password = Objects.requireNonNull(password);
        this.email = Objects.requireNonNull(email);
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

    public Email getEmail() {
        return email;
    }
}