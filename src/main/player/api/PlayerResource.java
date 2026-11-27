package player.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import player.api.dto.CreatePlayerRequest;
import player.application.CreatePlayerCommand;
import player.application.GetPlayerQuery;
import player.application.PlayerOutput;
import player.application.usecase.CreatePlayerUseCase;
import player.application.usecase.GetPlayerUseCase;

import java.net.URI;

@Path("/players")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlayerResource {
    private final CreatePlayerUseCase createPlayerUseCase;
    private final CreatePlayerRequestMapper requestMapper;
    private final GetPlayerUseCase getPlayerUseCase;
    private final PlayerResponseMapper responseMapper;

    public PlayerResource(
        CreatePlayerUseCase createPlayerUseCase,
        CreatePlayerRequestMapper requestMapper,
        GetPlayerUseCase getPlayerUseCase,
        PlayerResponseMapper responseMapper
    ) {
        this.createPlayerUseCase = createPlayerUseCase;
        this.requestMapper = requestMapper;
        this.getPlayerUseCase = getPlayerUseCase;
        this.responseMapper = responseMapper;
    }

    @POST
    public URI createPlayer(

            @NotNull @Valid CreatePlayerRequest request,
            @Context UriInfo uriInfo
    ) {
        CreatePlayerCommand command = requestMapper.toCommand(request);
        PlayerOutput player = createPlayerUseCase.execute(command);
        return uriInfo.getAbsolutePathBuilder().path(player.username()).build();
        }
    @GET
    @Path("{id}")
    public Response getPlayer(
            @HeaderParam("username") @NotNull String username
    ) {
        GetPlayerQuery query = new GetPlayerQuery(username);
        PlayerOutput player = getPlayerUseCase.execute(query);
        return Response.ok(responseMapper.toResponse(player)).build();
    }
}