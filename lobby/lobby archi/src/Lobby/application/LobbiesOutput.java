package Lobby.application;


import Lobby.domain.LobbyOverview;

import java.util.List;

public record LobbiesOutput(
        List<LobbyOverview> lobbies
) {
}
