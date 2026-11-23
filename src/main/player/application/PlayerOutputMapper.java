package main.player.application;

import main.player.domain.Player;

public class PlayerOutputMapper {
    public PlayerOutput toOutput(Player player) {
        return new PlayerOutput(
                player.id().value(),
                player.username().value(),
                player.email().value());
    }
}