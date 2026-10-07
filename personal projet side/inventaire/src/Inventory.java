import java.util.ArrayList;

public class Inventory {
    private final int MAX_CAPACITY = 10;
    private ArrayList<Items> items = new ArrayList<>();

    public Inventory() {
        this.items = new ArrayList<>();
        items.add(new Weapon("Epee Longue","Force","1d8"));
        items.add(new Weapon("Hache", "Force", "1d10"));
        items.add(new Weapon("Masse","Force","1d6"));
        items.add(new Armor("No Armure",10));
    } // Testing with inspiration of my old project, will be improved in the future.

    public boolean invRempli() {
        return items.size() >= MAX_CAPACITY;
    }

    public boolean ajoutItem(Items item) {
        if (invRempli()) {
            System.out.println("Inventaire plein");
            return false;
        }
        items.add(item);
        System.out.println("Added");
        return true;
    }

    public boolean retireItem(Items item) {
        if(items.contains(item)) {
            items.remove(item);
            System.out.println("Removed");
            return true;
        }
        return false;
    }
}
