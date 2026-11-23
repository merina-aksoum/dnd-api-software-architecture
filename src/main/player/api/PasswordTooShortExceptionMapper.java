package main.player.api;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import main.player.domain.exception.PasswordTooShortException;

import java.util.Map;

public class PasswordTooShortExceptionMapper implements ExceptionMapper<PasswordTooShortException> {
    private static final int UNPROCESSABLE_CONTENT = 422;
    @Override
    public Response toResponse(PasswordTooShortException exception) {
        return Response.status(UNPROCESSABLE_CONTENT)
                .type(MediaType.APPLICATION_JSON)
                .entity(Map.of("error", "PASSWORD_TOO_SHORT", "description", exception.getMessage()))
                .build();
    }
}
