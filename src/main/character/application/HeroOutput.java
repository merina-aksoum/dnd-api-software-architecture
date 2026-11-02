package character.application;

public record HeroOutput(
        String id,
        int level,
        int xp,
        int hp,
        int mp,
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
