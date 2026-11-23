package main.player.domain;

public interface PlayerRepository {
    void save(Player player);
    Player fetchById(PlayerId id);
    boolean isUsernameTaken(String username);
    boolean isEmailTaken(String email);
}
