package study.exception;

public class RetryException extends RuntimeException {
    public RetryException() {
        super();
    }

    public RetryException(String message) {
        super(message);
    }
}
