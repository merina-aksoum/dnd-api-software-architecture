package main.lobby.api;



public class LobbyResponseMapper {
    public GetLobbyResponse toResponse(LobbyOutput lobby) {
        return new GetLobbyResponse(
                lobby.lobbyId(),
                lobby.state(),
                lobby.players(),
                lobby.availableSeats());
    }

}
