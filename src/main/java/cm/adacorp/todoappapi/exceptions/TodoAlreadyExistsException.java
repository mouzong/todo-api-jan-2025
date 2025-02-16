package cm.adacorp.todoappapi.exceptions;

public class TodoAlreadyExistsException extends RuntimeException {
    public TodoAlreadyExistsException(String message) {
        super(message);
    }
}
