package character.domain.hero.characteristics;

public class Ability {

    private AbilityTypes type;
    private int rolledScore;
    private int score;
    private int modifier;

    public Ability(AbilityTypes type, int rolledScore, int speciesBonusMalus) {
        this.type = type;

        if (!isValidAbilityValue(rolledScore)) {
            throw new IllegalArgumentException("The value given to an ability should be between 3 and 18.");
        }

        this.score = applySpeciesBonus(speciesBonusMalus);

        this.modifier = calculateModifier();
    }

    public boolean isValidAbilityValue(int abilityValue) {
        return (abilityValue >= 3 && abilityValue <= 18);
    }

    private int applySpeciesBonus(int speciesBonusMalus) {
        return Math.min((rolledScore + speciesBonusMalus), 20);
    }

    public int calculateModifier() {
        return Math.floorDiv((score - 10), 2);
    }
}
