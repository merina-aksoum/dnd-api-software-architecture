package character.api;

import character.api.dto.CreateHeroRequest;
import character.application.CreateHeroCommand;
import character.application.CreateHeroUseCase;
import character.application.HeroOutput;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.core.MediaType;

import java.net.URI;

@Path("{playerId}/heroes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HeroResource {

    private final CreateHeroUseCase createHeroUseCase;
    private final CreateHeroRequestMapper requestMapper;

    public HeroResource(CreateHeroUseCase createHeroUseCase, CreateHeroRequestMapper requestMapper) {
        this.createHeroUseCase = createHeroUseCase;
        this.requestMapper = requestMapper;
    }

    @POST
    public Response createHero(
            @HeaderParam("Player") @NotNull String playerId,
            @NotNull @Valid CreateHeroRequest request,
            @Context UriInfo uriInfo
            ) {
        CreateHeroCommand command = requestMapper.toCommand(playerId, request);
        HeroOutput hero = createHeroUseCase.execute(command);
        URI location = uriInfo.getAbsolutePathBuilder().path(hero.id()).build();
        return Response.created(location).build();
    }

    @GET
    @Path("{playerId}/heroes/{heroId}")
    public Response getHero(@HeaderParam("Player") @NotNull String playerId, @PathParam("HeroId") String heroId) {
        GetHeroQuery query = new GetHeroQuery(heroId, playerId);
        HeroOutput output = getHeroUseCase.execute(query);
        return Response.ok(responseMapper.toResponse(hero)).build();
    }
}


