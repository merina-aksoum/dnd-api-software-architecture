package character.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Path("/restaurants")
public class HeroResource {

    private CreateHeroUseCase createHeroUseCase;
    private CreateHeroRequestMapper requestMapper;

    public HeroResource(CreateHeroUseCase createHeroUseCase, CreateHeroHRequestMapper requestMapper) {
        this.createHeroUseCase = createHeroUseCase;
        this.requestMapper = requestMapper;
    }

    @POST
    public Response createHero(
            @HeaderParam("Player") @NotNull String playerId,
            @NotNull @Valid CreateHeroRequest request,
            @Context UriInfo uriInfo
            ) {

    }
}


