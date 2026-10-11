package player.domain;

import java.util.ArrayList;
import character.domain.hero.*;

public class Player {
    private Username username;
    private Password password; // TODO: Find a way to make actually secured passwords
    private PlayerId id;
    private ArrayList<Hero> heroes;

    public Player(
            Username username,
            Password password) {
        this.username = username;
        this.password = password;
        this.id = PlayerId.generate();
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
        return username.value();
    }

    public String getPassword() {
        return password.value();
    }

    public String getId() {
        return id.value();
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }
}