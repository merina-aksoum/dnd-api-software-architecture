package main.player.application.usecase;

import main.player.application.GetPlayerQuery;
import main.player.application.PlayerOutput;
import main.player.application.PlayerOutputMapper;
import main.player.domain.PlayerId;
import main.player.domain.PlayerRepository;
import main.player.domain.Player;
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
        PlayerId playerId = new PlayerId(query.playerId());
        Player player = playerRepository.fetchById(playerId);

        if (player == null) {
            throw new PlayerNotFoundException(playerId);
        }

        return outputMapper.toOutput(player);
    }
}
