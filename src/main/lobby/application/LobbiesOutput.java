package Lobby.application;


import Lobby.domain.LobbyOverview;

import java.util.List;

public record LobbiesOutput(
        String id,
        String hostId,
        int playerCount,
        int maxPlayers
) {
}
