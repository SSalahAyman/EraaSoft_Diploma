package Task7;

// This is a custom exception that I create it to handle point of the code if it produces Runtime error
public class InvaildAgeException extends RuntimeException{
    public InvaildAgeException(String message){
        super(message);
    }
}
