package main.player.domain.exception;

import main.player.domain.Username;

public class UsernameAlreadyUsedException extends PlayerException {
    public UsernameAlreadyUsedException(Username username) {
        super(
                "Username " + username + " is already taken."
        );
    }
}
