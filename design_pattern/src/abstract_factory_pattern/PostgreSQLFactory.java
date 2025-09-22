package abstract_factory_pattern;

public class PostgreSQLFactory implements DatabaseFactory{
    @Override
    public Connection getConnection() {
        return new PostgreSQLConnection();
    }

    @Override
    public ResultSet getResultSet() {
        return new PostgreSQLResultSet();
    }

    @Override
    public Command getCommand() {
        return new PostfreSQLCommand();
    }
}
