package main.player.domain;

import java.util.ArrayList;

public class PlayerFactory {
    public Player create(
            String username,
            String email,
            String password
    ) {
        return new Player(
                PlayerId.generate(),
                new Username(username),
                new Email(email),
                new Password(password),
                new ArrayList<>()
        );

    }

}