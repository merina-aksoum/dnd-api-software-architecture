public class Weapon extends Items {
    private String caracteristique;
    private String degats; // TO BE CHANGED bc tf is that lol

    public Weapon(String nomItem, String caracteristique, String degats) {
        super(nomItem);
        this.caracteristique = caracteristique;
        this.degats = degats;
    }

    public String getCaracteristique() {
        return caracteristique;
    }

    public void setCaracteristique(String caracteristique) {
        this.caracteristique = caracteristique;
    }

    public String getDegats() {
        return degats;
    }

    public void setDegats(String degats) {
        this.degats = degats;
    }
}

