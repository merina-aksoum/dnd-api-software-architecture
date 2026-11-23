package main.player.application;

import main.player.domain.PlayerFactory;
import main.player.domain.PlayerId;
import main.player.domain.PlayerRepository;
import main.player.domain.Player;
import main.player.domain.exception.EmailAlreadyTakenException;
import main.player.domain.exception.UsernameAlreadyTakenException;

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
        String username = command.username();
        String email = command.email();

        if (playerRepository.isUsernameTaken(username)) {
            throw new UsernameAlreadyTakenException();
        }

        if (playerRepository.isEmailTaken(email)) {
            throw new EmailAlreadyTakenException();
        }

        Player player = playerFactory.create(
                command.username(),
                command.password(),
                command.email());

        playerRepository.save(player);

        return outputMapper.toOutput(player);
    }
}
