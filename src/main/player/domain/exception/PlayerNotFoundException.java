package player.domain.exception;

import player.domain.Username;

public class PlayerNotFoundException extends PlayerException {
    public PlayerNotFoundException(Username username) {
        super("Player with username " + username + "not found");
    }
}