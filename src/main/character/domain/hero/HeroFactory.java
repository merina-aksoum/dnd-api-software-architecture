package character.domain.hero;


import character.domain.hero.abilities.Abilities;
import character.domain.hero.abilities.Ability;
import character.domain.hero.abilities.AbilityBuilder;
import character.domain.hero.classes.ClassTypes;
import character.domain.hero.experience.ExperiencePoints;
import character.domain.hero.health.HealthPoints;
import character.domain.hero.level.Level;
import character.domain.hero.magic.MagicPoints;
import character.domain.hero.races.RaceTypes;
import character.domain.hero.name.Name;

import java.util.UUID;

public class HeroFactory {

        public Hero create(String nameString, int strengthValue, int dexterityValue, int constitutionValue, int intelligenceValue, int wisdomValue, int charismaValue, String raceValue, String heroClassValue) {

                RaceTypes race = RaceTypes.valueOf(raceValue);
                ClassTypes heroClass = ClassTypes.valueOf(heroClassValue);

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

                AbilityBuilder abilityBuilder = new AbilityBuilder(strengthValue, dexterityValue, constitutionValue, intelligenceValue, wisdomValue, charismaValue, race);
                Abilities abilities = abilityBuilder.setUpAbilities();

                Ability strength = abilities.getStrength();
                Ability dexterity = abilities.getDexterity();
                Ability constitution = abilities.getConstitution();
                Ability intelligence = abilities.getIntelligence();
                Ability wisdom = abilities.getWisdom();
                Ability charisma = abilities.getCharisma();

                Hero hero = new Hero(id, level, xp, hp, mp, name, strength, dexterity, constitution, intelligence, wisdom, charisma, race, heroClass);

                return hero;
        }


}
