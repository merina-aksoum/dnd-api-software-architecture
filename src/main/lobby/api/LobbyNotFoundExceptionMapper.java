package main.lobby.api;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import main.lobby.domain.exception.LobbyNotFoundException;

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
