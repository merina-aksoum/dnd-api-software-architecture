package test.player.domain.fixtures;

import main.player.domain.Email;

public class EmailFixture {
    public static final String EMAIL = "Alice@example.com";
    public static final String OTHER_EMAIL = "Bob@example.com";
    public static final String BLANK_EMAIL = "   ";

    private EmailFixture() {}

    public static Email aEmail() {return new Email(EMAIL);}
}