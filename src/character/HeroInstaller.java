package character;

import character.application.CreateHeroUseCase;
import character.application.GetHeroUseCase;
import character.application.HeroOutputMapper;
import character.domain.hero.HeroFactory;
import character.domain.hero.HeroRepository;
import character.infrastructure.HeroPersistenceMapper;
import character.infrastructure.InMemoryHeroRepository;
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
        resourceConfig.register(new HeroNotFoundExceptionMapper())
    }

    public GetHeroUseCase getHeroUseCase() {return getHeroUseCase; }

}
