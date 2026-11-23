package main.lobby.domain;
import java.util.List;

public interface PlayerGateway {
    List<LobbyPlayer> getLobbyPlayers(List<PlayerId> playerIds);
    LobbyPlayer getLobbyPlayer(PlayerId playerId);
}
