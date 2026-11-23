package test.player.domain.fixtures;

import main.player.domain.PlayerId;

public class PlayerIdFixture {
    private static final String ID = "player-1";
    private static final String OTHER_ID = "player-1";
    private static final String BLANK_ID = "player-";

    private PlayerIdFixture() {}

    public static PlayerId aPlayerId() {return new PlayerId(ID);}
    public static PlayerId anotherPlayerId() {return new PlayerId(OTHER_ID);}
    public static PlayerId aBlanklayerId() {return new PlayerId(BLANK_ID);}
}
