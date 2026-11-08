package main.player.domain;

public class PlayerFactory {
    public Player create(
            String id,
            String username,
            String password,
            String email) {
        return new Player(
                new PlayerId(id),
                new Username(username),
                new Password(password),
                new Email(email));

    }

}