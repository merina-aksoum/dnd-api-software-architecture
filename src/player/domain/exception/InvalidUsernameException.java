package player.domain.exception;

public class InvalidUsernameException extends PlayerException {
    public InvalidUsernameException() {
        super("""
                Username is invalid:
                    * Username length must be between 3 and 18 characters long
                    * Username may not contain special characters
                    * Username may not contains spaces""");
    }
}
