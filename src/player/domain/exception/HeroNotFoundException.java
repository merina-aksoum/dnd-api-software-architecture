package player.domain.exception;

public class HeroNotFoundException extends PlayerException {
    public HeroNotFoundException() {
        super("Hero was not found in ");
    }
}
