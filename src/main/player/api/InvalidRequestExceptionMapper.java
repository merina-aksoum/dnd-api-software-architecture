package main.player.api;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import main.player.domain.exception.InvalidEmailException;
import main.player.domain.exception.InvalidRequestException;

import java.util.Map;

public class InvalidRequestExceptionMapper implements ExceptionMapper<InvalidRequestException> {

    @Override
    public Response toResponse(InvalidRequestException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .type(MediaType.APPLICATION_JSON)
                .entity(Map.of("error", "INVALID_REQUEST", "description", exception.getMessage()))
                .build();
    }
}
