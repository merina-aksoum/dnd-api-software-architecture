package Lobby.domain;

import Lobby.domain.exception.InvalidCapacityException;

public record Capacity(int value) {
    private static final int MAX_PLAYERS = 4;
    private static final int MIN_PLAYERS = 1;

    public Capacity {
       if (value > MAX_PLAYERS || value < MIN_PLAYERS) {
           throw new InvalidCapacityException();
       }
    }
    public static Capacity defaultCapacity() {
        return new Capacity(MAX_PLAYERS);
    }

    public int availablePlayers(int playerCount) {
        return value - MIN_PLAYERS;
    }
}
