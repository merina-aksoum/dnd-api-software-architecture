package main.character.application;

import main.character.domain.hero.HeroFactory;
import main.character.domain.hero.HeroRepository;
import main.character.domain.hero.Hero;

public class CreateHeroUseCase {
    private HeroFactory heroFactory;
    private HeroRepository heroRepository;
    private HeroOutputMapper outputMapper;

    public CreateHeroUseCase(HeroFactory heroFactory, HeroRepository heroRepository, HeroOutputMapper outputMapper) {
        this.heroFactory = heroFactory;
        this.heroRepository = heroRepository;
        this.outputMapper = outputMapper;
    }

    public HeroOutput execute(CreateHeroCommand command) {
        Hero hero = heroFactory.create(
                command.name(),
                command.strength(),
                command.dexterity(),
                command.constitution(),
                command.intelligence(),
                command.wisdom(),
                command.charisma(),
                command.race(),
                command.heroClass()
        );

        heroRepository.save(hero);
        return outputMapper.toOutput(hero);
    }
}
