package Lobby.application;

import Lobby.domain.LobbyPlayer;

public class LobbyPlayerMapper {
    public static LobbyPlayer from(Player player) {
        return new LobbyPlayer(player.getId(), player.getUsername());
    }
}
