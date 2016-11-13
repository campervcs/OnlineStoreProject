package exceptions;

public class CantFindUserException extends Exception {
    @Override
    public String getMessage() {
        return "Wrong username or password";
    }
}
