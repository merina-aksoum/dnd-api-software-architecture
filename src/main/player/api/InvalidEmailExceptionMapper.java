package main.player.api;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import main.player.domain.exception.InvalidEmailException;

public class InvalidEmailExceptionMapper implements ExceptionMapper<InvalidEmailException> {
    @Override
    public Response toResponse(InvalidEmailException exception) {
        return Response.status(Response.Status.UNAUTHORIZED)
                .type(MediaType.TEXT_PLAIN)
                .entity(exception.getMessage())
                .build();
    }
}
