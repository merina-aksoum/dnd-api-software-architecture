package Lobby.application;

public record CreateLobbyCommand(
        String lobbyId,
        int lobbyCapacity,
        String status) {}

// Records are immutable data classes that require only the type
// and name of the fields.