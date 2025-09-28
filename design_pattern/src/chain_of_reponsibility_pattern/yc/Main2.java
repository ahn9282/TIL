package chain_of_reponsibility_pattern.yc;

public class Main2 {
    public static void main(String[] args) {
        Logger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(LogLevel.INFO, "This is an information");
        loggerChain.logMessage(LogLevel.DEBUG, "This is a debug level information");
        loggerChain.logMessage(LogLevel.WARN, "This is a warning information");
    }

    private static Logger getChainOfLoggers() {
        Logger networkLogger = new NetworkLogger(LogLevel.WARN);
        Logger fileLogger = new FileLogger(LogLevel.DEBUG);
        Logger consoleLogger = new ConsoleLogger(LogLevel.INFO);

        networkLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return networkLogger;
    }
}
