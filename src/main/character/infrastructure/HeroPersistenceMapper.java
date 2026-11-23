package main.character.infrastructure;

import main.character.domain.hero.Hero;
import main.character.domain.hero.HeroFactory;
import main.character.domain.hero.abilities.Ability;
import main.character.domain.hero.abilities.AbilityTypes;
import main.character.domain.hero.classes.ClassTypes;
import main.character.domain.hero.experience.ExperiencePoints;
import main.character.domain.hero.health.HealthPoints;
import main.character.domain.hero.level.Level;
import main.character.domain.hero.magic.MagicPoints;
import main.character.domain.hero.name.Name;
import main.character.domain.hero.races.RaceTypes;

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

