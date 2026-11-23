package main.player.api;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import main.player.domain.exception.PlayerException;

public class PlayerExceptionMapper implements ExceptionMapper<PlayerException> {
    private static final int UNPROCESSABLE_CONTENT = 422;

    @Override
    public Response toResponse(PlayerException exception) {
        return Response.status(UNPROCESSABLE_CONTENT)
                .type(MediaType.TEXT_PLAIN_TYPE)
                .entity(exception.getMessage())
                .build();
    }
}