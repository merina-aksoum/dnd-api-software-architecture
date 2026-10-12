package character.infrastructure;

import character.domain.hero.Hero;

public class HeroPersistenceMapper {

    public HeroPersistenceModel toPersistence(Hero hero) {
        return new HeroPersistenceModel(
                hero.getId(),
                hero.getLevel(),
                hero.getXp(),
                hero.getMp(),
                hero.getName(),
                hero.getStrength(),
                hero.getDexterity(),
                hero.getConstitution(),
                hero.getIntelligence(),
                hero.getWisdom(),
                hero.getCharisma(),
                hero.getRace(),
                hero.getHeroClass()
        );
    }
}
