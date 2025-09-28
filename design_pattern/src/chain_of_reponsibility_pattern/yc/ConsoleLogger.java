package chain_of_reponsibility_pattern.yc;

public class ConsoleLogger extends Logger {

    public ConsoleLogger(LogLevel level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Console::Logger : " + message);
    }
}
