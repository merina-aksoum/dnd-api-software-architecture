package Lobby.api;

import Lobby.api.dto.GetLobbyResponse;
import Lobby.application.LobbyOutput;

public class LobbyResponseMapper {
    public GetLobbyResponse toResponse(LobbyOutput lobby) {
        return new GetLobbyResponse(
                lobby.lobbyId(),
                lobby.capacity(),
                lobby.status());
    }

    public GetLobbiesResponse toResponse(LobbiesOutput lobbies) {
        return new GetLobbiesResponse(lobbies);
    }
}
