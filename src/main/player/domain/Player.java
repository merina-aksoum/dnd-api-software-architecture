package main.player.domain;

import java.util.Objects;
import java.util.List;

public class Player {

    private PlayerId id;
    private Username username;
    private Email email;
    private Password password;
    private List<HeroId> heroes;

    public Player(
            PlayerId id,
            Username username,
            Email email,
            Password password,
            List<HeroId> heroes
    ) {
        this.id = Objects.requireNonNull(id);
        this.username = Objects.requireNonNull(username);
        this.email = Objects.requireNonNull(email);
        this.password = Objects.requireNonNull(password);
        this.heroes = Objects.requireNonNull(heroes);
    }

    public Username username() {
        return username;
    }

    public Password password() {
        return password;
    }

    public PlayerId id() {
        return id;
    }

    public Email email() {
        return email;
    }

    public List<HeroId> heroes() { return heroes; }
}