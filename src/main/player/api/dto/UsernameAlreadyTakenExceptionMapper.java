package main.player.api.dto;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import main.player.domain.exception.UsernameAlreadyUsedException;

public class UsernameAlreadyTakenExceptionMapper implements ExceptionMapper<UsernameAlreadyUsedException> {
    public Response toResponse(UsernameAlreadyUsedException exception) {
        return Response.status(Response.Status.fromStatusCode(409))
                .type(MediaType.TEXT_PLAIN)
                .entity(exception.getMessage())
                .build();
    }
}
