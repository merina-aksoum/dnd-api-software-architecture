package main.lobby.api;

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
import java.util.List;

@Path("/lobbies")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LobbyResource {

    private final CreateLobbyRequestMapper createLobbyRequestMapper;
    private final CreateLobbyUseCase createLobbyUseCase;
    private final GetLobbyUseCase getLobbyUseCase;
    private final GetLobbiesUseCase getLobbiesUseCase;
    private final JoinLobbyUseCase joinLobbyUseCase;
    private final LeaveLobbyUseCase leaveLobbyUseCase;
    private final LobbyResponseMapper responseMapper;

    public LobbyResource(
            CreateLobbyUseCase createLobbyUseCase,
            CreateLobbyRequestMapper createLobbyRequestMapper,
            GetLobbyUseCase getLobbyUseCase,
            GetLobbiesUseCase getLobbiesUseCase,
            JoinLobbyUseCase joinLobbyUseCase,
            LeaveLobbyUseCase leaveLobbyUseCase,
            LobbyResponseMapper responseMapper) {
        this.createLobbyUseCase = createLobbyUseCase;
        this.createLobbyRequestMapper = createLobbyRequestMapper;
        this.getLobbyUseCase = getLobbyUseCase;
        this.getLobbiesUseCase = getLobbiesUseCase;
        this.joinLobbyUseCase = joinLobbyUseCase;
        this.leaveLobbyUseCase = leaveLobbyUseCase;
        this.responseMapper = responseMapper;
    }

    @POST
    public Response createLobby(
            @HeaderParam("Lobby") @NotNull String lobbyId,
            @NotNull @Valid CreateLobbyRequest request,
            @Context UriInfo uriInfo) {
        CreateLobbyCommand command = createLobbyRequestMapper.toCommand(lobbyId, request);
        LobbyOutput lobby = createLobbyUseCase.execute(command);
        URI location = uriInfo.getAbsolutePathBuilder().path(lobbyId).build();
        return Response.created(location).build();
    }

    @GET
    @Path("/{lobbyId}")
    public Response getLobby(
            @NotNull @PathParam("lobbyId") String lobbyId) {
        GetLobbyQuery query = new GetLobbyQuery(lobbyId);
        LobbyOutput lobby = getLobbyUseCase.execute(query);
        return Response.ok(responseMapper.toResponse(lobby)).build();
    }

    @GET
    @Path("")
    public Response getLobbies() {
        List<LobbiesOutput> lobbies = getLobbiesUseCase.execute();
        return Response.ok(lobbies).build();
    }

    @POST
    @Path("/{lobbyId}/players")
    public Response joinLobby(
            @HeaderParam("Player") @NotNull String playerId,
            @PathParam("lobbyId") @NotNull String lobbyId,
            @Context UriInfo uriInfo) {
        JoinLobbyCommand command = new JoinLobbyCommand(lobbyId, playerId);
        LobbyOutput lobby = joinLobbyUseCase.execute(command);
        URI location = uriInfo.getAbsolutePathBuilder().path(playerId).build();
        return Response.created(location).entity(responseMapper.toResponse(lobby)).build();
    }

    @DELETE
    @Path("/{lobbyId}/players/{playerId}")
    public Response leaveLobby(
            @HeaderParam("Player") @NotNull String connectedPlayerId,
            @PathParam("lobbyId") @NotNull String lobbyId,
            @PathParam("playerId") @NotNull String playerId
    ) {
        LeaveLobbyCommand command = new LeaveLobbyCommand(lobbyId, playerId);
        leaveLobbyUseCase.execute(command);
        return Response.noContent().build();
    }
}
