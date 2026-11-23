package main.hero.api;

import main.hero.api.dto.GetHeroResponse;
import main.hero.application.HeroOutput;

public class HeroResponseMapper {
    public GetHeroResponse toResponse(HeroOutput hero) {
        return new GetHeroResponse(
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
                hero.charisma(),
                hero.wisdom(),
                hero.race(),
                hero.heroClass()
        );
    }
}
