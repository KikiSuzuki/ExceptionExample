/**
 * InvalidCredentialsException is a self-defined Exceptions, that will occur if username or password is invalid
 * is Checked Exception
 */
public class InvalidCredentialsException extends Exception{
    public InvalidCredentialsException(String errorMessage) {
        super(errorMessage); //simple example will return errorMessage
    }
}
