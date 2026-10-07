package Lobby.application.LobbyCreationUseCase;

public record LobbyCreationCommand (
        String lobbyId,
        int lobbyCapacity) {}

// Records are immutable data classes that require only the type
// and name of the fields.