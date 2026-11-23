package main.lobby.api;


import main.lobby.api.dto.GetLobbyResponse;
import main.lobby.application.LobbyOutput;

public class LobbyResponseMapper {
    public GetLobbyResponse toResponse(LobbyOutput lobby) {
        return new GetLobbyResponse(
                lobby.lobbyId(),
                lobby.state(),
                lobby.players(),
                lobby.availableSeats());
    }

}
