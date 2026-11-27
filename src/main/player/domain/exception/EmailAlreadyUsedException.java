package player.domain.exception;

import player.domain.Email;

public class EmailAlreadyUsedException extends PlayerException {

    public EmailAlreadyUsedException(Email email) {
        super("Email " + email.value() + " is already taken.");
    }
}