package main.hero.application;

import main.hero.domain.Hero;
import main.hero.domain.HeroRepository;

import java.util.UUID;

public class GetHeroUseCase {

    private final HeroRepository heroRepository;
    private final HeroOutputMapper outputMapper;

    public GetHeroUseCase(HeroRepository heroRepository, HeroOutputMapper outputMapper) {
        this.heroRepository = heroRepository;
        this.outputMapper = outputMapper;
    }

    public HeroOutput execute(GetHeroQuery query) {
        UUID heroId = UUID.fromString(query.heroId());
        //TODO: complete playerID once player implementation is complete
        Hero hero = heroRepository.fetchById(heroId);
        return outputMapper.toOutput(hero);
    }
}
