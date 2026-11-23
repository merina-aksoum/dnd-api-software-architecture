package main.lobby.infra;

import Lobby.domain.PlayerGateway;

import java.util.ArrayList;
import java.util.List;

public class InProcessPlayerGateway implements PlayerGateway {

    private final GetPlayersUseCase getPlayers;
    private final GetPlayerUseCase getPlayer;

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

        List<LobbyPlayer> LobbyPlayers = new ArrayList<>();
        for (Player player : players) {
            LobbyPlayers.add(new LobbyPlayer(player.id(), player.pesudonym(), player.heroes()); //TODO: À CORRIGER AVEC LES BONS PARAMÈTRES
        }
        return LobbyPlayers;
    }

    public LobbyPlayer getLobbyPlayer(PlayerId playerId) {
        Player player = getPlayer.execute(new GetPlayerQuery(playerId));
        LobbyPlayer lobbyPlayer = toLobbyPlayer(player);
        return lobbyPlayer;
    }

    public LobbyPlayer toLobbyPlayer(Player player) {
        LobbyPlayer lobbyPlayer = new LobbyPlayer(player.id(), player.pseudonym(), player.heroes());
        return lobbyPlayer;
    }
}
