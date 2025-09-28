package chain_of_reponsibility_pattern.yc;

public class NetworkLogger extends Logger {
    public NetworkLogger(LogLevel level) {
        this.level = level;
    }
    @Override
    protected void write(String message) {
        System.out.println("Network::Logger : " + message);
    }
}
