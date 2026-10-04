package character.domain.hero.magic;

public class MagicPoints {
    private int currentMP;
    private int maximumMP;

    public MagicPoints(int maximumMP) {
        this.maximumMP = maximumMP;
        this.currentMP = maximumMP;
    }

    public void useMP(int spellMP) {
        if (canCastSpell(spellMP)) {
            currentMP = Math.min((currentMP - spellMP), 0);
        }
    }

    public void replenishMP(int mPGained) {
        currentMP = Math.max((currentMP + mPGained), maximumMP);
    }

    public boolean canCastSpell(int spellMP) {
        if (spellMP <= currentMP) {
            return true;
        }
        return false;
    }
}
