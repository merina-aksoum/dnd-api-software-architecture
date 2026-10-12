package character.domain.hero;

import character.domain.hero.classes.ClassTypes;
import character.domain.hero.experience.ExperiencePoints;
import character.domain.hero.health.HealthPoints;
import character.domain.hero.level.Level;
import character.domain.hero.magic.MagicPoints;
import character.domain.hero.name.Name;

import character.domain.hero.abilities.Ability;
import character.domain.hero.races.RaceTypes;

import java.util.UUID;

public class Hero {

        private UUID id;

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

        public Hero(
                    UUID id,
                    Level level,
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
            this.id = id;
            this.level = level;
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

    public String id() {
        return id.toString();
    }

    public int level() {
        return level.value();
    }

    public int xp() {
        return xp.getCurrentXP();
    }

    public int hp() {
        return hp.getCurrentHP();
    }

    public int mp() {
        return mp.getCurrentMP();
    }

    public String name() {
        return name.toString();
    }

    public int strength() {
        return strength.getScore();
    }

    public int dexterity() { return dexterity.getScore();}

    public int constitution() {
        return constitution.getScore();
    }

    public int intelligence() {
        return intelligence.getScore();
    }

    public int charisma() {
        return charisma.getScore();
    }

    public int wisdom() {
        return wisdom.getScore();
    }

    public String raceValue() {
        return race.toString();
    }

    public String heroClassValue() {return heroClass.toString();}

}
