package main.player.api;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import main.player.domain.exception.EmailAlreadyUsedException;

public class EmailAlreadyUsedExceptionMapper implements ExceptionMapper<EmailAlreadyUsedException> {
    public Response toResponse(EmailAlreadyUsedException exception) {
        return Response.status(Response.Status.fromStatusCode(409))
                .type(MediaType.TEXT_PLAIN)
                .entity(exception.getMessage())
                .build();
    }
}
