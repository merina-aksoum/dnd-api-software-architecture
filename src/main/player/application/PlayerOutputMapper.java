package player.application;

import player.domain.Player;

public class PlayerOutputMapper {
    public PlayerOutput toOutput(Player player) {
        return new PlayerOutput(
                player.getUsername().value(),
                player.getEmail().value());
    }
}