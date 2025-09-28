package chain_of_reponsibility_pattern.yc;

public abstract class Logger {
    protected LogLevel level;
    protected Logger nextLogger;

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(LogLevel level, String message) {
        if(this.level.ordinal() <= level.ordinal()){
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    protected abstract void write(String message) ;
}
