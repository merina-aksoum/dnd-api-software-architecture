package character.infrastructure;

public record HeroPersistenceModel(
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
