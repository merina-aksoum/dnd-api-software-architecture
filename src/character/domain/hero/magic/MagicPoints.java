package character.domain.hero.magic;

public class MagicPoints {
    private int currentMP;
    private int maximumMP;

    public MagicPoints(int currentMP, int maximumMP) {
        this.maximumMP = maximumMP;
        this.currentMP = maximumMP;
    }
}
