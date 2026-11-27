package player.api;

import player.api.dto.CreatePlayerRequest;
import player.application.CreatePlayerCommand;

public class PlayerApiMapper {
    public CreatePlayerCommand toCommand(CreatePlayerRequest request) {
        return new CreatePlayerCommand(
                request.username(),
                request.password(),
                request.email()
        );
    }
}