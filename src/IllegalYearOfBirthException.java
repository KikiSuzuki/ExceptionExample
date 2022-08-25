/**
 * IllegalYearOfBirthException is a self-defined Exception class, that will occur if the year entered is less than 18 or more than 100
 * is Unchecked Exception*/

public class IllegalYearOfBirthException extends RuntimeException {
    public IllegalYearOfBirthException(String errorMessage) {
        super(errorMessage); //simple example will return errorMessage
    }
}
