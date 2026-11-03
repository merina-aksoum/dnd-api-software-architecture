package main.player.application;

import main.player.domain.Player;

public class PlayerOutputMapper {
    public PlayerOutput toOutput(Player player) {
        return new PlayerOutput(
                player.getId().value(),
                player.getUsername().value(),
                player.getPassword().value());
    }
}