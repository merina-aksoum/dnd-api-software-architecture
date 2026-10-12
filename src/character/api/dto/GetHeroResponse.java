package character.api.dto;

public record GetHeroResponse(String id,
                              int level,
                              XP xp,
                              HP hp,
                              MP mp,
                              String name,
                              Ability strength,
                              Ability dexterity,
                              Ability constitution,
                              Ability intelligence,
                              Ability wisdom,
                              Ability charisma,
                              String race,
                              String heroClass) {
    public record XP(int current, int max) {}
    public record HP(int current, int max) {}
    public record MP(int current, int max) {}
    public record Ability(int value, int modifier) {}

}
