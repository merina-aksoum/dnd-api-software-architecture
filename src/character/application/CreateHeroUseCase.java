package character.application;

import character.domain.hero.HeroFactory;
import character.domain.hero.HeroRepository;
import character.domain.hero.Hero;

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
                command.playerId(),
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
