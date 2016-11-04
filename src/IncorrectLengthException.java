public class IncorrectLengthException extends Exception {
    public IncorrectLengthException(String message, Throwable throwable) {
        super(message, throwable);
    }
    public IncorrectLengthException(String message) {
        super(message);
    }
}