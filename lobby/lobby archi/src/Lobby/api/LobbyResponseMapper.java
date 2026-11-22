package Lobby.api;

import Lobby.api.dto.GetLobbyResponse;
import Lobby.application.LobbiesOutput;
import Lobby.application.LobbyOutput;

public class LobbyResponseMapper {
    public GetLobbyResponse toResponse(LobbyOutput lobby) {
        return new GetLobbyResponse(
                lobby.lobbyId(),
                lobby.state(),
                lobby.players(),
                lobby.availableSeats());
    }

    public GetLobbiesResponse toResponse(LobbiesOutput lobbies) {
        return new GetLobbiesResponse(lobbies);
    }
}
