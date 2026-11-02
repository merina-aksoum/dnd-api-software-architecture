package main.character.domain.hero.name;

import main.character.domain.hero.exceptions.InvalidNameFormatException;
import main.character.domain.hero.exceptions.InvalidNameLengthException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Name {

    private String name;

    public Name(String name) {

        name = name.trim();

        if (name.length() < 2 || name.length() > 30) {
            throw new InvalidNameLengthException();
        }

        if (!isValidName(name)) {
            throw new InvalidNameFormatException();
        }

        //verify in the list that the name is not found twice

        this.name = name;
    }

    private boolean isValidName(String name) {
        Pattern pattern = Pattern.compile("^[a-zA-Z\\s]+$");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}
