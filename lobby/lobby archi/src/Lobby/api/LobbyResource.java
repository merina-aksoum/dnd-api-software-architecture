package Lobby.api;

import Lobby.api.dto.CreateLobbyRequest;
import Lobby.application.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;

@Path("/lobby")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LobbyResource {
    private final CreateLobbyUseCase createLobbyUseCase;
    private final CreateLobbyRequest requestMapper;
    private final GetLobbyUseCase getLobbyUseCase;
    private final LobbyResponseMapper responseMapper;

    public LobbyResource(
            CreateLobbyUseCase createLobbyUseCase,
            CreateLobbyRequest requestMapper,
            GetLobbyUseCase getLobbyUseCase,
            LobbyResponseMapper responseMapper) {
        this.createLobbyUseCase = createLobbyUseCase;
        this.requestMapper = requestMapper;
        this.getLobbyUseCase = getLobbyUseCase;
        this.responseMapper = responseMapper;
    }

    @POST
    public Response createLobby(
            @HeaderParam("Lobby") @NotNull String lobbyId,
            @NotNull @Valid CreateLobbyRequest request,
            @Context UriInfo uriInfo) {
        CreateLobbyCommand command = requestMapper.toCommand(lobbyId, request);
        LobbyOutput lobby = createLobbyUseCase.execute(command);
        URI location = uriInfo.getAbsolutePathBuilder().path(lobbyId).build();
        return Response.created(location).build();
    }
    @GET
    @PATH("{lobbyId}")
    public Response getLobby(
            @HeaderParam("Lobby") @NotNull String lobbyId, @PathParam("id") String lobbyId) {
        GetLobbyQuery query = new GetLobbyQuery(lobbyId);
        LobbyOutput lobby = getLobbyUseCase.execute(query);
        return Response.ok(responseMapper.toResponse(lobby)).build();
    }
}
