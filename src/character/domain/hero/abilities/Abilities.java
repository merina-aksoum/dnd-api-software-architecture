package character.domain.hero.abilities;

public class Abilities {

    private Ability strength;
    private Ability dexterity;
    private Ability constitution;
    private Ability intelligence;
    private Ability wisdom;
    private Ability charisma;

    public Ability getStrength() {
        return strength;
    }

    public Ability getDexterity() {
        return dexterity;
    }

    public Ability getConstitution() {
        return constitution;
    }

    public Ability getIntelligence() {
        return intelligence;
    }

    public Ability getWisdom() {
        return wisdom;
    }

    public Ability getCharisma() {
        return charisma;
    }

    public Abilities(Ability strength, Ability dexterity, Ability constitution, Ability intelligence, Ability wisdom, Ability charisma) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;


    }
}
