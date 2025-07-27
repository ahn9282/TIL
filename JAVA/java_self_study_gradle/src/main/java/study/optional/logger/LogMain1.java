package study.optional.logger;

public class LogMain1 {
    public static void main(String[] args) {
        LoggerOptional logger = new LoggerOptional();
        logger.setDebug(false);
        logger.debug(10 + 20);

        System.out.println("=== debug mode off ===");
        logger.setDebug(true);
        logger.debug(100 + 200);

    }
}
