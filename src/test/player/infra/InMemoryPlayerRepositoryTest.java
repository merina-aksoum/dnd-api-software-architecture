package player.infra;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import player.domain.Player;
import player.domain.Username;
import player.domain.exception.PlayerNotFoundException;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static player.domain.fixtures.PlayerBuilder.aPlayer;

public class InMemoryPlayerRepositoryTest {
    private final InMemoryPlayerRepository repository = new InMemoryPlayerRepository(new PlayerPersistenceMapper());

    @Test
    public void savedPlayer_isFetchedWithUsername() {
        Player player = aPlayer().build();

        repository.save(player);
        Player fetched = repository.fetchByUsername(player.getUsername());
        assertThat(fetched.getUsername()).isEqualTo(player.getUsername());
        assertThat(fetched.getEmail()).isEqualTo(player.getEmail());
        assertThat(fetched.getPassword()).isEqualTo(player.getPassword());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"Niflax", "Albert"})
    public void unknownPlayer_isNotFound(String value) {
        Username unknownUsername = new Username(value);
        assertThrows(PlayerNotFoundException.class, () -> repository.fetchByUsername(unknownUsername));
    }
}