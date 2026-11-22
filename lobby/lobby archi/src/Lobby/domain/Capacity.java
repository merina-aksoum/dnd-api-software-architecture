package Lobby.domain;

import Lobby.domain.exception.InvalidCapacityException;

public record Capacity(int value) {
    private static final int MAX_PLAYERS = 4;

    public Capacity {
        int availableSeats = MAX_PLAYERS - players.Count();


       if (value > MAX_PLAYERS) {
           throw new InvalidCapacityException();
       }
    }
}
