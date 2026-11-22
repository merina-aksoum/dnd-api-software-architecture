package Lobby.domain;
import java.util.List;

public interface PlayerGateway {
    List<PlayerOverview> getLobbyPlayers(List<PlayerId> playerIds);
}
