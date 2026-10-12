package character.api;

import character.api.dto.CreateHeroRequest;
import character.application.CreateHeroCommand;

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
