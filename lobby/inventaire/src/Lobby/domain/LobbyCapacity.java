package Lobby.domain;

import java.util.LinkedList;

public record LobbyCapacity() {
    private static final int MAX_PLAYERS = 4;

    static LinkedList<PlayerTEST> allPlayers = new LinkedList<>();

    public boolean addPlayer (PlayerTEST playerTEST) {
        if (allPlayers.size() > MAX_PLAYERS) {
            System.out.println("The lobby is full, please join another one or try again later.");
        } else if (allPlayers.size() < MAX_PLAYERS) {
            allPlayers.add(playerTEST);
            System.out.println((playerTEST.getName() + " is now playing in this lobby."));
        } else {
            throw new RuntimeException();
        }
        return false;
    }
}
