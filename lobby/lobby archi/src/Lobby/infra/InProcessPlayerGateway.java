package Lobby.infra;

import Lobby.domain.PlayerGateway;

import java.util.List;

public class InProcessPlayerGateway implements PlayerGateway {

    private final GetPlayersUseCase getPlayers;

    public InProcessPlayerGateway(GetPlayersUseCase getPlayers) {
        this.getPlayers = getPlayers;
    }

    @Override
    public List<LobbyPlayer> getLobbyPlayers(List<PlayerId> playerIds) {
        List<Player> playersList = getPlayers.execute(new GetPlayersQuery(playerIds));
        List<LobbyPlayer> LobbyPlayers = toLobbyPlayers(playersList);
        return LobbyPlayers;
    }

    public List<LobbyPlayer> toLobbyPlayers(List<Player> players) {

        List<LobbyPlayer> LobbyPlayers = new List<LobbyPlayer>();
        for (Player player : players) {
            LobbyPlayers.add(new LobbyPlayer(player.id(), player.pesudonym(), player.heroes()); //TODO: À CORRIGER AVEC LES BONS PARAMÈTRES
        }
        return LobbyPlayers;
    }
}
