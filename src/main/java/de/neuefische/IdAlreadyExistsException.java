package de.neuefische;

public class IdAlreadyExistsException extends Exception{

    public IdAlreadyExistsException(String message) {
        super(message);
    }

    public IdAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
