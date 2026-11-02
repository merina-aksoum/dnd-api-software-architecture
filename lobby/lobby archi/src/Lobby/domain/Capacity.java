package Lobby.domain;

public record Capacity(int value) {
    private static final int MAX_PLAYERS = 4;

    public Capacity {
       if (value > MAX_PLAYERS) {
           throw new IllegalArgumentException(); //Changer dans InvalidCapacityException
       }
    }
}
