package character.domain.hero.classes;

public enum ClassTypes {

    FIGHTER(12),
    RANGER(10),
    WIZARD(6),
    CLERIC(10);

    private int baseHP;

    ClassTypes(int baseHP) {
        this.baseHP = baseHP;
    }

    public int getBaseHP() {
        return baseHP;
    }
}
