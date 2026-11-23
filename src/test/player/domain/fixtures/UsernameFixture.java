package test.player.domain.fixtures;

import main.player.domain.Username;

public class UsernameFixture {
    public static final String USERNAME = "Bob";
    public static final String OTHER_USERNAME = "Xx_Al1c3_L0v3r_<3_xX";
    public static final String BLANK_USERNAME = "   ";

    private UsernameFixture() {}

    public static Username aUsername() {return new Username(USERNAME);}
    public static Username anotherUsername() {return new Username(OTHER_USERNAME);}
    public static Username aBlankUsername() {return new Username(BLANK_USERNAME);}
}