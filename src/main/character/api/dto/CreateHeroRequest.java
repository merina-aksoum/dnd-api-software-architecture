package character.api.dto;

import jakarta.validation.constraints.NotNull;

public record CreateHeroRequest(
        @NotNull String name,
        @NotNull Integer strength,
        @NotNull Integer dexterity,
        @NotNull Integer constitution,
        @NotNull Integer intelligence,
        @NotNull Integer wisdom,
        @NotNull Integer charisma,
        @NotNull String race,
        @NotNull String heroClass) {

}
