package Lobby.domain;

import javax.script.SimpleBindings;
import java.util.LinkedList;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingDeque;

public class Lobby {
    private static final int MAX_PLAYERS = 4;
    private final UUID lobbyId;

    public Lobby(UUID lobbyId,int MAX_PLAYERS) {
        this.lobbyId = lobbyId;
    }

    LinkedList<PlayerTEST> allPlayers = new LinkedList<>();

    public boolean addPlayer (PlayerTEST playerTEST) {
        if (allPlayers.size() > MAX_PLAYERS) {
            System.out.println("The lobby is full, please join another one or try again later.");
        } else if (allPlayers.size() < MAX_PLAYERS) {
            allPlayers.add(playerTEST);
            System.out.println((playerTEST.getName() + " is now playing in this lobby."));
        }
        return false;
    }
}
