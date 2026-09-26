package character.domain.hero.abilities;

import character.domain.hero.races.RaceTypes;

import java.util.HashMap;
import java.util.Map;

public class AbilityBuilder {

    Map<AbilityTypes, Integer> playerAbilitiesData;
    RaceTypes race;
    Map<AbilityTypes, Ability> abilities;

    public AbilityBuilder(Map<AbilityTypes, Integer> playerAbilitiesData, RaceTypes race) {
        this.playerAbilitiesData = playerAbilitiesData;
        this.race = race;
        this.abilities = setUpAbilities();
    }

    public Map<AbilityTypes, Ability> setUpAbilities() {

        abilities = new HashMap<>();

        for (Map.Entry<AbilityTypes, Integer> abilityData : playerAbilitiesData.entrySet()) {

            AbilityTypes type = abilityData.getKey();
            int abilityValue = abilityData.getValue();
            int speciesBonusMalus = getAbilitySpeciesModifier(type);
            Ability ability = new Ability(type, abilityValue, speciesBonusMalus);
            abilities.put(type, ability);
        }

        return abilities;
    }

    public int getAbilitySpeciesModifier(AbilityTypes abilityType) {
        return race.getSpeciesModifiers().getOrDefault(abilityType, 0);
    }

}
