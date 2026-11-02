package main.character.api;

import main.character.api.dto.CreateHeroRequest;
import main.character.application.CreateHeroCommand;

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
