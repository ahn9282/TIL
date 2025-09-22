package abstract_factory_pattern;

public class MySQLFactory implements DatabaseFactory{
    @Override
    public Connection getConnection() {
        return new MySQLConnection();
    }

    @Override
    public ResultSet getResultSet() {
        return new MySQLResultSet();
    }

    @Override
    public Command getCommand() {
        return new MySQLCommand();
    }
}
