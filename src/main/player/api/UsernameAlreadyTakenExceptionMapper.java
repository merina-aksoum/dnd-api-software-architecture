package main.player.api;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import main.player.domain.exception.UsernameAlreadyTakenException;

import java.util.Map;

public class UsernameAlreadyTakenExceptionMapper implements ExceptionMapper<UsernameAlreadyTakenException> {
    @Override
    public Response toResponse(UsernameAlreadyTakenException exception) {
        return Response.status(Response.Status.CONFLICT)
                .type(MediaType.APPLICATION_JSON)
                .entity(Map.of("error", "USERNAME_TAKEN", "description", exception.getMessage()))
                .build();
    }
}
