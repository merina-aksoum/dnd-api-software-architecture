package test.player.domain.fixtures;

import main.player.domain.Password;

public class PasswordFixture {
    public static final String PASSWORD = "12345";
    public static final String OTHER_PASSWORD = "NnaquX=HF690*!n@r8oA";
    public static final String BLANK_PASSWORD = "   ";

    private PasswordFixture() {}

    public static Password aPassword() {return new Password(PASSWORD);}
}
