package character.domain.hero.abilities;

import character.domain.hero.races.RaceTypes;

public class AbilityBuilder {

    private int strengthPlayer;
    private int dexterityPlayer;
    private int constitutionPlayer;
    private int intelligencePlayer;
    private int wisdomPlayer;
    private int charismaPlayer;
    private RaceTypes race;
    private Abilities abilities;

    public AbilityBuilder(int strengthPlayer, int dexterityPlayer, int constitutionPlayer, int intelligencePlayer, int wisdomPlayer, int charismaPlayer ,RaceTypes race) {
        this.strengthPlayer = strengthPlayer;
        this.dexterityPlayer = dexterityPlayer;
        this.constitutionPlayer = constitutionPlayer;
        this.intelligencePlayer = intelligencePlayer;
        this.wisdomPlayer = wisdomPlayer;
        this.charismaPlayer = charismaPlayer;
        this.race = race;
        this.abilities = setUpAbilities();
    }

    public Abilities setUpAbilities() {

        Ability strength = new Ability(AbilityTypes.STRENGTH, strengthPlayer, getAbilitySpeciesModifier(AbilityTypes.STRENGTH));
        Ability dexterity = new Ability(AbilityTypes.DEXTERITY  , dexterityPlayer, getAbilitySpeciesModifier(AbilityTypes.DEXTERITY ));
        Ability constitution = new Ability(AbilityTypes.CONSTITUTION, constitutionPlayer, getAbilitySpeciesModifier(AbilityTypes.CONSTITUTION));
        Ability intelligence = new Ability(AbilityTypes.INTELLIGENCE, intelligencePlayer, getAbilitySpeciesModifier(AbilityTypes.INTELLIGENCE));
        Ability wisdom = new Ability(AbilityTypes.WISDOM, wisdomPlayer, getAbilitySpeciesModifier(AbilityTypes.WISDOM ));
        Ability charisma = new Ability(AbilityTypes.CHARISMA, charismaPlayer, getAbilitySpeciesModifier(AbilityTypes.CHARISMA));

        return new Abilities(strength, dexterity, constitution, intelligence, wisdom, charisma);
    }

    public int getAbilitySpeciesModifier(AbilityTypes abilityType) {
        return race.getSpeciesModifiers().getOrDefault(abilityType, 0);
    }
}




