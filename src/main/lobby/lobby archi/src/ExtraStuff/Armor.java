public class Armor extends Items {
    private int classeArmure;

    public Armor(String nomItem, int classeArmure) {
        super(nomItem);
        this.classeArmure = classeArmure;
    }

    public int getClasseArmure() {
        return classeArmure;
    }

    public void setClasseArmure(int classeArmure) {
        this.classeArmure = classeArmure;
    }
}
