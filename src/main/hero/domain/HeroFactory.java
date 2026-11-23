package main.hero.domain;


import main.hero.domain.abilities.Abilities;
import main.hero.domain.abilities.Ability;
import main.hero.domain.abilities.AbilityBuilder;
import main.hero.domain.classes.ClassTypes;
import main.hero.domain.experience.ExperiencePoints;
import main.hero.domain.health.HealthPoints;
import main.hero.domain.level.Level;
import main.hero.domain.magic.MagicPoints;
import main.hero.domain.races.RaceTypes;
import main.hero.domain.name.Name;

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
