package main.hero.infrastructure;

import main.hero.domain.Hero;
import main.hero.domain.HeroFactory;
import main.hero.domain.abilities.Ability;
import main.hero.domain.abilities.AbilityTypes;
import main.hero.domain.classes.ClassTypes;
import main.hero.domain.experience.ExperiencePoints;
import main.hero.domain.health.HealthPoints;
import main.hero.domain.level.Level;
import main.hero.domain.magic.MagicPoints;
import main.hero.domain.name.Name;
import main.hero.domain.races.RaceTypes;

import java.util.UUID;

public class HeroPersistenceMapper {

    public HeroPersistenceModel toPersistence(Hero hero) {
        return new HeroPersistenceModel(
                hero.id(),
                hero.level(),
                hero.xp(),
                hero.hp(),
                hero.mp(),
                hero.name(),
                hero.strength(),
                hero.dexterity(),
                hero.constitution(),
                hero.intelligence(),
                hero.wisdom(),
                hero.charisma(),
                hero.raceValue(),
                hero.heroClassValue()
        );
    }
    
    public Hero toDomain(HeroPersistenceModel model) {
        HeroFactory factory = new HeroFactory();

        return new Hero(
                UUID.fromString(model.id()),
                new Level(model.level()),
                new ExperiencePoints(1, 1), //PLACEHOLDER
                new HealthPoints(1),
                new MagicPoints(1),
                new Name("whatever"),
                new Ability(AbilityTypes.STRENGTH, 3, 6),
                new Ability(AbilityTypes.STRENGTH, 3, 6),
                new Ability(AbilityTypes.STRENGTH, 3, 6),
                new Ability(AbilityTypes.STRENGTH, 3, 6),
                new Ability(AbilityTypes.STRENGTH, 3, 6),
                new Ability(AbilityTypes.STRENGTH, 3, 6),
                RaceTypes.valueOf(model.race()),
                ClassTypes.valueOf(model.heroClass())
        );

        //question: comment reconstruire dans ce cas-ci l'objet au complet à partir de valeurs simples? représentation du domaine incompatible ou potentiellement trop complexe


    }
}

