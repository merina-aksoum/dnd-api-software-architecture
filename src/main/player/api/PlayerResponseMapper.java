package player.api;

import player.api.dto.GetPlayerResponse;
import player.application.PlayerOutput;

public class PlayerResponseMapper {
    public GetPlayerResponse toResponse(PlayerOutput player) {
        return new GetPlayerResponse(
                player.username(),
                player.email()
        );
    }
}