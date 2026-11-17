package test.player.domain.fixtures;

import static test.player.domain.fixtures.EmailFixture.aEmail;
import static test.player.domain.fixtures.PasswordFixture.aPassword;

import static test.player.domain.fixtures.UsernameFixture.aUsername;

import main.player.domain.*;

public class PlayerBuilder {
    private Username username = aUsername();
    private Email email = aEmail();
    private Password password = aPassword();

    public static PlayerBuilder aPlayer() {return new PlayerBuilder();}

    public PlayerBuilder withUsername(Username username) {
        this.username = username;
        return this;
    }

    public PlayerBuilder withEmail(Email email) {
        this.email = email;
        return this;
    }

    public PlayerBuilder withPassword(Password password) {
        this.password = password;
        return this;
    }

    public Player build() {
        return new Player(
            username, password, email
        );
    }
}