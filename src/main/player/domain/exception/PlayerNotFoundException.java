package main.player.domain.exception;

import main.player.domain.PlayerId;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(PlayerId id) {
        super("Player with id " + id + "not found");
    }
}