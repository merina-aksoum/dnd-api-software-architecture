package Lobby.api;

import Lobby.domain.Lobby;
import Lobby.domain.exception.LobbyNotFoundException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class LobbyNotFoundExceptionMapper implements ExceptionMapper<LobbyNotFoundException> {

    @Override
    public Response toResponse(LobbyNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .type(MediaType.TEXT_PLAIN)
                .entity(exception.getMessage())
                .build();
    }
}
