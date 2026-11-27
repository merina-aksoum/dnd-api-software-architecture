package player.api;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import player.domain.exception.PasswordTooShortException;

public class PasswordTooShortExceptionMapper implements ExceptionMapper<PasswordTooShortException> {
    public Response toResponse(PasswordTooShortException exception) {
        return Response.status(Response.Status.fromStatusCode(422))
                .type(MediaType.TEXT_PLAIN)
                .entity(exception.getMessage())
                .build();
    }
}
