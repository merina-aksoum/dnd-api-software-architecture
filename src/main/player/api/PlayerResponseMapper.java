package main.player.api;

import main.player.api.dto.GetPlayerResponse;
import main.player.application.PlayerOutput;

public class PlayerResponseMapper {
    public GetPlayerResponse toResponse(PlayerOutput player) {
        return new GetPlayerResponse(
                player.id(),
                player.username(),
                player.password(),
                player.email()
        );
    }
}