package Lobby.api;

import Lobby.api.dto.CreateLobbyRequest;
import Lobby.application.CreateLobbyCommand;

public class CreateLobbyRequestMapper {

    public CreateLobbyCommand toCommand(String lobbyId, CreateLobbyRequest request) {
        return new CreateLobbyCommand(
                lobbyId,
                request.capacity(),
                request.status());
    }
}
