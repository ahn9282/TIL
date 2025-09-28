package chain_of_reponsibility_pattern.yc;

public class FileLogger extends Logger {
    public FileLogger(LogLevel level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger : " + message);
    }
}
