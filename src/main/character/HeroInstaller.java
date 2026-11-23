package main.character;

import main.character.api.Hero;
import main.character.api.HeroNotFoundExceptionMapper;
import main.character.application.CreateHeroUseCase;
import main.character.application.GetHeroUseCase;
import main.character.application.HeroOutputMapper;
import main.character.domain.hero.HeroFactory;
import main.character.domain.hero.HeroRepository;
import main.character.infrastructure.HeroPersistenceMapper;
import main.character.infrastructure.InMemoryHeroRepository;
import org.glassfish.jersey.server.ResourceConfig;

public class HeroInstaller {
    private final HeroRepository heroRepository;
    private final GetHeroUseCase getHeroUseCase;

    public HeroInstaller() {
        this.heroRepository = new InMemoryHeroRepository(new HeroPersistenceMapper());
        this.getHeroUseCase = new GetHeroUseCase(heroRepository, new HeroOutputMapper()); //output mapper
    }

    public void install(ResourceConfig resourceConfig) {
        HeroOutputMapper outputMapper = new HeroOutputMapper();
        CreateHeroUseCase createHeroUseCase = new CreateHeroUseCase(
                new HeroFactory(), heroRepository, outputMapper);
        GetHeroUseCase getHeroUseCase = new GetHeroUseCase(heroRepository, outputMapper);
        resourceConfig.register(new HeroExceptionMapper());
        resourceConfig.register(new HeroNotFoundExceptionMapper());
    }

    public GetHeroUseCase getHeroUseCase() {return getHeroUseCase; }

}
