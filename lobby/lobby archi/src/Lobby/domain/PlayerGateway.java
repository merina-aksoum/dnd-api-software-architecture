package Lobby.domain;
import java.util.List;

public interface PlayerGateway {
    List<PlayerOverview> getPlayerOverviews(List<PlayerId> playerIds);
}
