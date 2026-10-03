package character.domain.hero;

import character.domain.hero.classes.ClassTypes;
import character.domain.hero.experience.ExperiencePoints;
import character.domain.hero.health.HealthPoints;
import character.domain.hero.level.Level;
import character.domain.hero.magic.MagicPoints;

import character.domain.hero.Name;
import character.domain.hero.abilities.Ability;
import character.domain.hero.races.RaceTypes;

public class Hero {

        private Level level;
        private ExperiencePoints xp;
        private HealthPoints hp;
        private MagicPoints mp;

        private Name name;
        private Ability strength;
        private Ability dexterity;
        private Ability constitution;
        private Ability intelligence;
        private Ability wisdom;
        private Ability charisma;

        private RaceTypes race;
        private ClassTypes heroClass;

        public Hero(Level level,
                    ExperiencePoints xp,
                    HealthPoints hp,
                    MagicPoints mp,
                    Name name,
                    Ability strength,
                    Ability dexterity,
                    Ability constitution,
                    Ability intelligence,
                    Ability wisdom,
                    Ability charisma,
                    RaceTypes race,
                    ClassTypes heroClass) {
            this.xp = xp;
            this.hp = hp;
            this.mp = mp;
            this.name = name;
            this.strength = strength;
            this.dexterity = dexterity;
            this.constitution = constitution;
            this.intelligence = intelligence;
            this.wisdom = wisdom;
            this.charisma = charisma;
            this.race = race;
            this.heroClass = heroClass;
        }
}
