package main.player.api;

import main.player.api.dto.CreatePlayerRequest;
import main.player.application.CreatePlayerCommand;

public class CreatePlayerRequestMapper {
    public CreatePlayerCommand toCommand(CreatePlayerRequest request) {
        return new CreatePlayerCommand(
                request.id(),
                request.username(),
                request.password(),
                request.email()
        );
    }
}