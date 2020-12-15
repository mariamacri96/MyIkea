package team2.storehouse.exceptions;

public class UserAlredyExistException  extends RuntimeException {

    public UserAlredyExistException(String username) {
        super("A user already exists with this " + username);
    }
}