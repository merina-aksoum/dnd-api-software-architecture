package main.player.api;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import main.player.domain.exception.EmailAlreadyTakenException;

import java.util.Map;

public class EmailAlreadyTakenExceptionMapper implements ExceptionMapper<EmailAlreadyTakenException> {
    @Override
    public Response toResponse(EmailAlreadyTakenException exception) {
        return Response.status(Response.Status.CONFLICT)
                .type(MediaType.APPLICATION_JSON)
                .entity(Map.of("error", "EMAIL_TAKEN", "description", exception.getMessage()))
                .build();
    }
}
