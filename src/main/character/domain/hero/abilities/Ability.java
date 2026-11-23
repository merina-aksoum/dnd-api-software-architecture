package main.character.domain.hero.abilities;

import main.character.domain.hero.exceptions.InvalidAbilityValueException;

public class Ability {

    private AbilityTypes type;
    private int rolledScore;
    private int score;
    private int modifier;
    private int temporaryModifier;

    public Ability(AbilityTypes type, int rolledScore, int speciesModifier) {
        this.type = type;

        if (!isValidAbilityValue(rolledScore)) {
            throw new InvalidAbilityValueException();
        }

        this.score = applySpeciesBonus(speciesModifier);

        this.modifier = calculateModifier();
    }

    public boolean isValidAbilityValue(int abilityValue) {
        return (abilityValue >= 3 && abilityValue <= 18);
    }

    private int applySpeciesBonus(int speciesModifier) {
        return Math.min((rolledScore + speciesModifier), 20);
    }

    public int calculateModifier() {
        return Math.floorDiv((score - 10), 2);
    }

    public void applyBonus(int temporaryModifier) {
        this.temporaryModifier = temporaryModifier;
        score = Math.min((score + temporaryModifier), 20);
        modifier = calculateModifier();
    }

    public void applyMalus(int temporaryModifier) {
        this.temporaryModifier = temporaryModifier;
        score = Math.max((score - temporaryModifier), 0);
        modifier = calculateModifier();
    }

    public int getScore() {
        return score;
    }

    public int getModifier() {
        return modifier;
    }
}
