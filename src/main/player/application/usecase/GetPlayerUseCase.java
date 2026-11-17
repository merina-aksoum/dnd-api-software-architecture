package main.player.application.usecase;

import main.player.application.GetPlayerQuery;
import main.player.application.PlayerOutput;
import main.player.application.PlayerOutputMapper;
import main.player.domain.PlayerRepository;
import main.player.domain.Player;
import main.player.domain.Username;
import main.player.domain.exception.PlayerNotFoundException;

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
