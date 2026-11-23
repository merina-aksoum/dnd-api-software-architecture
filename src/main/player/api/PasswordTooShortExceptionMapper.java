package main.player.api;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import main.player.domain.exception.PasswordTooShortException;

public class PasswordTooShortExceptionMapper implements ExceptionMapper<PasswordTooShortException> {
    @Override
    public Response toResponse(PasswordTooShortException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .type(MediaType.TEXT_PLAIN)
                .entity(exception.getMessage())
                .build();
    }
}
