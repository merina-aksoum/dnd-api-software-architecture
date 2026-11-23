package main.lobby.api;


import main.lobby.api.dto.CreateLobbyRequest;
import main.lobby.application.CreateLobbyCommand;

public class CreateLobbyRequestMapper {

    public CreateLobbyCommand toCommand(String lobbyId, CreateLobbyRequest request) {
        return new CreateLobbyCommand(
                lobbyId,
                request.capacity(),
                request.status());
    }
}
