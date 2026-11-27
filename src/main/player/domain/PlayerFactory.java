package player.domain;

public class PlayerFactory {
    public Player create(
            String username,
            String password,
            String email) {
        return new Player(
                new Username(username),
                new Password(password),
                new Email(email));

    }

}