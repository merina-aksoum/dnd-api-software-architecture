package main.lobby.domain;

import java.util.List;

public record LobbyPlayer(
        String playerId,
        String username,
        List<HeroOverview> selectedHero;
) {
}
