package character.domain.hero.experience;

public class ExperiencePoints {

    private int currentXP;
    private int maximumXP;

    public ExperiencePoints(int maximumXP) {
        currentXP = 0;
        this.maximumXP = maximumXP;
    }

    public int getCurrentXP() {
        return currentXP;
    }

    public int getMaximumXP() {
        return maximumXP;
    }
}
