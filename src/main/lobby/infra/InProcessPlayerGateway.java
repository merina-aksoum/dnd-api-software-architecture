package main.lobby.infra;


import main.lobby.domain.LobbyPlayer;
import main.lobby.domain.PlayerGateway;
import main.player.application.GetPlayerQuery;
import main.player.application.GetPlayerUseCase;
import main.player.domain.Player;
import main.player.domain.PlayerId;

import java.util.ArrayList;
import java.util.List;

public class InProcessPlayerGateway implements PlayerGateway {

    private final GetPlayersUseCase getPlayers;
    private final GetPlayerUseCase getPlayer;

    public InProcessPlayerGateway(GetPlayersUseCase getPlayers, GetPlayerUseCase getPlayer) {
        this.getPlayers = getPlayers;
        this.getPlayer = getPlayer;
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
            LobbyPlayers.add(new LobbyPlayer(player.id().value(), player.username().value(), player.heroes()); //TODO: À CORRIGER AVEC LES BONS PARAMÈTRES
        }
        return LobbyPlayers;
    }

    public LobbyPlayer getLobbyPlayer(PlayerId playerId) {
        Player player = getPlayer.execute(new GetPlayerQuery(playerId));
        LobbyPlayer lobbyPlayer = toLobbyPlayer(player);
        return lobbyPlayer;
    }

    public LobbyPlayer toLobbyPlayer(Player player) {
        LobbyPlayer lobbyPlayer = new LobbyPlayer(player.id().value(), player.username().value(), player.heroes()); //TODO: COMPLETE WITH HERO REPRESENTATION
        return lobbyPlayer;
    }
}
