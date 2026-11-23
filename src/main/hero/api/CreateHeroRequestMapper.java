package main.hero.api;

import main.hero.api.dto.CreateHeroRequest;
import main.hero.application.CreateHeroCommand;

public class CreateHeroRequestMapper {

    public CreateHeroCommand toCommand(String playerId, CreateHeroRequest request) {
        return new CreateHeroCommand(
                playerId,
                request.name(),
                request.strength(),
                request.dexterity(),
                request.constitution(),
                request.intelligence(),
                request.wisdom(),
                request.charisma(),
                request.race(),
                request.heroClass()
        );
    }
}
