package exceptions;
public class UserExistException extends Exception {
    @Override
    public String getMessage() {
        return "Username already exsist";
    }
}
