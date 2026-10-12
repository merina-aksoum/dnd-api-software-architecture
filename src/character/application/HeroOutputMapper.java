package character.application;

import character.domain.hero.Hero;

public class HeroOutputMapper {
    public HeroOutput toOutput(Hero hero) {
        return new HeroOutput(
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
                hero.raceValue(),
                hero.heroClassValue()
        );
    }
}
