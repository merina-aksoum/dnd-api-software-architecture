package character.domain.hero.races;

import character.domain.hero.abilities.AbilityTypes;

import java.util.Map;

public enum RaceTypes {

    HUMAN(
            Map.of(
                    AbilityTypes.STRENGTH, 1,
                    AbilityTypes.DEXTERITY, 1,
                    AbilityTypes.CONSTITUTION, 1,
                    AbilityTypes.INTELLIGENCE, 1,
                    AbilityTypes.WISDOM, 1,
                    AbilityTypes.CHARISMA,1
            )
    ),
    ELF(
            Map.of(
                    AbilityTypes.DEXTERITY, 2,
                    AbilityTypes.INTELLIGENCE, 1
            )
    ),
    DWARF(
            Map.of(
                    AbilityTypes.CONSTITUTION, 2,
                    AbilityTypes.STRENGTH, 1
            )
    ),
    ORCA(
            Map.of(
                    AbilityTypes.STRENGTH, 2,
                    AbilityTypes.CONSTITUTION, 1,
                    AbilityTypes.INTELLIGENCE, -1
            )
    );

    private final Map<AbilityTypes, Integer> speciesModifiers;

    RaceTypes(Map<AbilityTypes, Integer> speciesModifiers) {
        this.speciesModifiers = speciesModifiers;
    }

    public Map<AbilityTypes, Integer> getSpeciesModifiers() {
        return speciesModifiers;
    }
}
