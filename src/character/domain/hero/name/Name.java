package character.domain.hero;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Name {

    private String name;

    public Name(String name) {

        name = name.trim();

        if (name.length() < 2 || name.length() > 30) {
            throw new IllegalArgumentException("The hero name should have between 2 and 30 characters.");
        }

        if (!isValidName(name)) {
            throw new IllegalArgumentException("The name should only contain letters and spaces.");
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
