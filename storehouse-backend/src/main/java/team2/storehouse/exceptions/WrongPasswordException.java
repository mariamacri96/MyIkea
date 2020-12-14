package team2.storehouse.exceptions;

public class WrongPasswordException extends RuntimeException {

    public WrongPasswordException(String username) {
        super("wrong password for username " + username);
    }
}
