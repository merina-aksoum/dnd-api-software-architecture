package character.domain.hero.health;

public class HealthPoints {

    private int currentHP;
    private int maximumHP;

    public HealthPoints(int currentHP, int maximumHP) {
        this.maximumHP = maximumHP;
        this.currentHP = maximumHP;
    }

    public void takeDamage(int damageTaken) {
        currentHP = Math.max((currentHP - damageTaken), 0);
    }

    public void heal(int hpGained) {
        currentHP = Math.min((currentHP + hpGained), maximumHP);
    }

    public int getMaximumHP() {
        return maximumHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }
}
