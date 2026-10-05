package character.domain.hero;

import character.domain.hero.Name;
import character.domain.hero.abilities.Ability;
import character.domain.hero.abilities.AbilityBuilder;
import character.domain.hero.abilities.AbilityTypes;
import character.domain.hero.classes.ClassTypes;
import character.domain.hero.experience.ExperiencePoints;
import character.domain.hero.health.HealthPoints;
import character.domain.hero.level.Level;
import character.domain.hero.magic.MagicPoints;
import character.domain.hero.races.RaceTypes;

import java.util.Map;
import java.util.UUID;

public class HeroFactory {

        public Hero create(String nameString, Map<AbilityTypes, Integer> abilitiesData, RaceTypes race, ClassTypes heroClass) {

                UUID id = UUID.randomUUID();
                Level level = new Level(1);
                ExperiencePoints xp = new ExperiencePoints(0,300);
                HealthPoints hp = new HealthPoints(heroClass.getBaseHP());

                int magicPoints = 0;

                if (heroClass.equals(ClassTypes.WIZARD)) {
                        magicPoints = 10;
                }

                MagicPoints mp = new MagicPoints(magicPoints);

                Name name = new Name(nameString);

                AbilityBuilder abilityBuilder = new AbilityBuilder(abilitiesData, race);
                Map<AbilityTypes, Ability> abilities = abilityBuilder.setUpAbilities();
                Ability strength = abilities.get(AbilityTypes.STRENGTH);
                Ability dexterity = abilities.get(AbilityTypes.DEXTERITY);
                Ability constitution = abilities.get(AbilityTypes.CONSTITUTION);
                Ability intelligence = abilities.get(AbilityTypes.INTELLIGENCE);
                Ability wisdom = abilities.get(AbilityTypes.WISDOM);
                Ability charisma = abilities.get(AbilityTypes.CHARISMA);

                Hero hero = new Hero(id, level, xp, hp, mp, name, strength, dexterity, constitution, intelligence, wisdom, charisma, race, heroClass);

                return hero;
        }


}
