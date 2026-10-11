package player.domain;

import java.util.UUID;
import java.util.Objects;

public record PlayerId(String value) {

    public PlayerId {
        Objects.requireNonNull(value);
    }

    public static PlayerId generate() {
        return new PlayerId(UUID.randomUUID().toString());
    }
}