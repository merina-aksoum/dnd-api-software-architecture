package main.player.application.usecase;

import main.player.application.CreatePlayerCommand;
import main.player.application.PlayerOutput;
import main.player.application.PlayerOutputMapper;
import main.player.domain.*;

public class CreatePlayerUseCase {
    private final PlayerFactory playerFactory;
    private final PlayerRepository playerRepository;
    private final PlayerOutputMapper outputMapper;

    public CreatePlayerUseCase(
            PlayerFactory playerFactory,
            PlayerRepository playerRepository,
            PlayerOutputMapper outputMapper) {
        this.playerFactory = playerFactory;
        this.playerRepository = playerRepository;
        this.outputMapper = outputMapper;
    }

    public PlayerOutput execute(CreatePlayerCommand command) {
        Player player = playerFactory.create(
                command.username(),
                command.password(),
                command.email());

        if (playerRepository.isUsed(player.getEmail(), player.getUsername())) {
            return outputMapper.toOutput(new Player(
                    new Username(""),
                    new Password(""),
                    new Email("")
            ));
        }

        playerRepository.save(player);

        return outputMapper.toOutput(player);
    }
}
