package character.domain;

import java.util.ArrayList;
import java.util.UUID;
import character.domain.hero.*;

public class Player {
    private String username; // TODO: Get client's requirements for usernames requirement
    private String password; // TODO: Find a way to make actually secured passwords
    private UUID id;
    private ArrayList<Hero> heroes;

    public Player(
            String username,
            String password) {
        this.username = username;
        this.password = password;
        this.id = UUID.randomUUID();
        this.heroes = new ArrayList<>();
    }

    public Hero getHero(Hero hero) throws Exception {
        if (heroes.contains(hero)) {
            int heroIndex = heroes.indexOf(hero);
            Hero result = heroes.get(heroIndex);
            return result;
        } else {
            throw new Exception("Hero not found");
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UUID getId() {
        return id;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }
}