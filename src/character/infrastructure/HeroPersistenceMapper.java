package character.infrastructure;

import character.domain.hero.Hero;
import character.domain.hero.HeroFactory;
import character.domain.hero.classes.ClassTypes;
import character.domain.hero.experience.ExperiencePoints;
import character.domain.hero.level.Level;
import character.domain.hero.races.RaceTypes;

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

        //incomplete - ask question
        
        return new Hero(
                UUID.fromString(model.id()),
                new Level(model.level()),
                new ExperiencePoints(),
                model.hp(),
                model.mp(),
                model.name(),
                model.strength(),
                model.dexterity(),
                model.constitution(),
                model.intelligence(),
                model.wisdom(),
                model.charisma(),
                RaceTypes.valueOf(model.race()),
                ClassTypes.valueOf(model.heroClass())
        )


    }
}
