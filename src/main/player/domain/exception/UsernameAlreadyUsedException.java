package player.domain.exception;

import player.domain.Username;

public class UsernameAlreadyUsedException extends PlayerException {
    public UsernameAlreadyUsedException(Username username) {
        super(
                "Username " + username.value() + " is already taken."
        );
    }
}
