package main.player.domain;

public class PlayerFactory {
    public Player create(
            String id,
            String username,
            String password) {
        return new Player(
                new PlayerId(id),
                new Username(username),
                new Password(password));
    }

}