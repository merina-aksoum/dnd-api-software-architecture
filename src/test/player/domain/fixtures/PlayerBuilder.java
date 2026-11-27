package player.domain.fixtures;

import static player.domain.fixtures.EmailFixture.aEmail;
import static player.domain.fixtures.PasswordFixture.aPassword;
import player.domain.Username;
import player.domain.Email;
import player.domain.Password;
import player.domain.Player;

import static player.domain.fixtures.UsernameFixture.aUsername;


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