package exceptions;
public class UserExistException extends Exception {
    private String username;
    public UserExistException(String message, String username)
    {
        super(message);
        this.username=username;
    }
    public String getUsername(){
        return username;
    }
}
