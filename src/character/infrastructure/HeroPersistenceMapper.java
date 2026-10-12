package character.infrastructure;

import character.domain.hero.Hero;

public class HeroPersistenceMapper {

    public HeroPersistenceModel toPersistence(Hero hero) {
        return new HeroPersistenceModel(
                hero.id(),
                hero.level(),
                hero.xp(),
                hero.mp(),
                hero.name(),
                hero.strength(),
                hero.dexterity(),
                hero.constitution(),
                hero.intelligence(),
                hero.wisdom(),
                hero.charisma(),
                hero.race(),
                hero.heroClass()
        );
    }
}
