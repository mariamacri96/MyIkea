package team2.storehouse.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String user) {
        super("the user " + user + " doesn't exist");
    }
}
