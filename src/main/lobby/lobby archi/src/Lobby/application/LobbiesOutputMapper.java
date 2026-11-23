package Lobby.application;

import Lobby.domain.LobbyOverview;

import java.util.ArrayList;
import java.util.List;

public class LobbiesOutputMapper {
    public List<LobbiesOutput> toOutput(List<LobbyOverview> lobbyOverviews) {
        List<LobbiesOutput> lobbyOutputs = new ArrayList<>();
        for (LobbyOverview overview : lobbyOverviews) {
            LobbiesOutput output = new LobbiesOutput(overview.id().value(), overview.hostId().value(), overview.playerCount(), overview.maxPlayers().value());
            lobbyOutputs.add(output);
        }
        return lobbyOutputs;
    }
}
