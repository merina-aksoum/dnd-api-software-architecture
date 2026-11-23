package main.lobby.domain;

import java.util.List;

public record LobbyPlayer(
        String id,
        String username,
        List<HeroOverview> selectedHero;
) {
}
