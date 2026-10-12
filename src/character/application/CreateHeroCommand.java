package character.application;

public record CreateHeroCommand(
        String playerId,
        String name,
        int strength,
        int dexterity,
        int constitution,
        int intelligence,
        int wisdom,
        int charisma,
        String race,
        String heroClass
) {

}
