package Lobby.infra;

import Lobby.domain.PlayerGateway;

import java.util.List;

public class InProcessPlayerGateway implements PlayerGateway {

    private final GetPlayersUseCase getPlayers;

    public InProcessPlayerGateway(GetPlayersUseCase getPlayers) {
        this.getPlayers = getPlayers;
    }

    @Override
    public List<PlayerOverview> getPlayerOverviews(List<PlayerId> playerIds) {
        List<Player> playersList = getPLayers.execute(new GetPlayersQuery(playerIds));
        List<PlayerOverview> playerOverviews = toPlayerOverviews(playersList);
        return playerOverviews;
    }

    public List<PlayerOverview> toPlayerOverviews(List<Player> players) {

        List<PlayerOverview> playerOverviews = new List<PlayerOverview>();
        for (Player player : players) {
            playerOverviews.add(new PlayerOverview(player.id(), player.pesudonym(), player.heroes()); //TODO: À CORRIGER AVEC LES BONS PARAMÈTRES
        }
        return playerOverviews;
    }
}
