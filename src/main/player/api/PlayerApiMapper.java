package main.player.api;

import main.player.api.dto.CreatePlayerRequest;
import main.player.application.CreatePlayerCommand;

public class PlayerApiMapper {
    public CreatePlayerCommand toCommand(CreatePlayerRequest request) {
        return new CreatePlayerCommand(
                request.username(),
                request.password(),
                request.email()
        );
    }
}