package player.application.usecase;

import player.application.GetPlayerQuery;
import player.application.PlayerOutput;
import player.application.PlayerOutputMapper;
import player.domain.Player;
import player.domain.PlayerRepository;
import player.domain.Username;
import player.domain.exception.PlayerNotFoundException;

public class GetPlayerUseCase {
    private final PlayerRepository playerRepository;
    private final PlayerOutputMapper outputMapper;

    public GetPlayerUseCase(
            PlayerRepository playerRepository,
            PlayerOutputMapper outputMapper
    ) {
        this.playerRepository = playerRepository;
        this.outputMapper = outputMapper;
    }

    public PlayerOutput execute(GetPlayerQuery query) {
        Username username = new Username(query.username());
        Player player = playerRepository.fetchByUsername(username);

        if (player == null) {
            throw new PlayerNotFoundException(username);
        }

        return outputMapper.toOutput(player);
    }
}
