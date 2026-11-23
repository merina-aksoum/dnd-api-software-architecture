package main.character.api.dto;

public record GetHeroResponse(String id,
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
                              String heroClass) {

    public record Ability(int value, int modifier) {}

}
