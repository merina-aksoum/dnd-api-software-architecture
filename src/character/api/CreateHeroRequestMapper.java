package character.api;

public class CreateHeroRequestMapper {

    public CreateHeroCommand toCommand(String playerId, CreateHeroRequest request) {
        return new CreateHeroCommand(
                playerId,
                request.name();
        )
    }
}
