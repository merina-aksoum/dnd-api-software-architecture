package character.application;

import character.domain.hero.HeroFactory;

public class CreateHeroUseCase {
    private HeroFactory heroFactory;
    private HeroRepository heroRepository;
    private HeroOutputMapper outputMapper;

    public CreateHeroUseCase(HeroFactory heroFactory, HeroRepository heroRepository, HeroOutputMapper outputMapper) {
        this.heroFactory = heroFactory;
        this.heroRepository = heroRepository;
        this.outputMapper = outputMapper;
    }
}
