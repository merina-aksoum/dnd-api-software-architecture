public abstract class Items {
    private String nomItem;
    // ajouter un avec les degats

    public Items(String nomItem) {
        this.nomItem = nomItem;
    }

    public String getNomItem() {
        return nomItem;
    }

    public void setNomItem(String nomItem) {
        this.nomItem = nomItem;
    }
}

