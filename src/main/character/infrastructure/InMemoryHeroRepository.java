package character.infrastructure;

import character.domain.hero.Hero;
import character.domain.hero.HeroRepository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryHeroRepository implements HeroRepository {

    private final Map<String, HeroPersistenceModel> heroes = new ConcurrentHashMap<>();
    private final HeroPersistenceMapper persistenceMapper;

    public InMemoryHeroRepository(HeroPersistenceMapper persistenceMapper) {
        this.persistenceMapper = persistenceMapper;
    }

    @Override
    public void save(Hero hero) {
        HeroPersistenceModel model = persistenceMapper.toPersistence(hero);
        heroes.put(model.id(), model);
    }

    @Override
    public Hero fetchById(UUID id) {
        HeroPersistenceModel model = heroes.get(id.toString());
        return persistenceMapper.toDomain(model);
    }
}
