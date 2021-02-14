package shapes;

// Customize exception handler
public class WrongValueException extends Exception{
    public WrongValueException(String message) {
        super(message);
    }
}
