package main.player.domain;

import java.util.Objects;

public class Player {
    private Username username;
    private Password password;
    private Email email;

    public Player(
            Username username,
            Password password, Email email) {
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

    public Email getEmail() {
        return email;
    }
}