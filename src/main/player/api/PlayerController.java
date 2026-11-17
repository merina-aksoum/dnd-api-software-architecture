package main.player.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import main.player.api.dto.CreatePlayerRequest;
import main.player.application.CreatePlayerCommand;
import main.player.application.usecase.CreatePlayerUseCase;

@Path("/players")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlayerController {

    private final CreatePlayerUseCase createPlayerUseCase;
    private final PlayerApiMapper playerApiMapper;

    public PlayerController(CreatePlayerUseCase createPlayerUseCase,
                            PlayerApiMapper playerApiMapper) {
        this.createPlayerUseCase = createPlayerUseCase;
        this.playerApiMapper = playerApiMapper;
    }

    @POST
    public Response createPlayer(@Valid @NotNull CreatePlayerRequest request) {
        CreatePlayerCommand command = playerApiMapper.toCommand(request);
        createPlayerUseCase.execute(command);
        return Response.status(Response.Status.CREATED).build();
    }
}