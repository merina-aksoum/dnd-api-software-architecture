package main.lobby.domain;
import main.player.domain.PlayerId;

import java.util.List;

public interface PlayerGateway {
    List<LobbyPlayer> getLobbyPlayers(List<PlayerId> playerIds);
    LobbyPlayer getLobbyPlayer(PlayerId playerId);
}
