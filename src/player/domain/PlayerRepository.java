package player.domain;

public interface PlayerRepository {
    void save(Player player);

    Player fetchById(PlayerId id);
}
