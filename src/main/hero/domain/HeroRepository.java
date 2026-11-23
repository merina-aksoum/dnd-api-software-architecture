package main.hero.domain;

import java.util.UUID;

public interface HeroRepository {
    void save(Hero hero);
    Hero fetchById(UUID id);
}
