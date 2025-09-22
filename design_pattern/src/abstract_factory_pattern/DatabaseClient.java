package abstract_factory_pattern;

public class DatabaseClient {
    private Connection connection;
    private Command command;
    private ResultSet resultSet;

    public DatabaseClient(DatabaseFactory factory) {
        this.connection = factory.getConnection();
        this.command = factory.getCommand();
        this.resultSet = factory.getResultSet();
    }

    public void performDatabaseOperation(){
        connection.open();
        command.execute("SELECT * FROM users");
        resultSet.getResults();
        connection.close();
    }
}
