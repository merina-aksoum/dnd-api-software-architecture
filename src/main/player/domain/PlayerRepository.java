package player.domain;

public interface PlayerRepository {
    void save(Player player);
    Player fetchByUsername(Username username);
    boolean isUsed(Email email, Username username);
}
