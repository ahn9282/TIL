package study.service_abstract.ex;

public class TestUserServiceException extends RuntimeException {
    public TestUserServiceException() {
    }

    public TestUserServiceException(String message) {
        super(message);
    }

    public TestUserServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestUserServiceException(Throwable cause) {
        super(cause);
    }

    public TestUserServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

