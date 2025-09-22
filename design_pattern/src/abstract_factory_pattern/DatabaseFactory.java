package abstract_factory_pattern;

public interface DatabaseFactory {
    Connection getConnection();
    ResultSet getResultSet();
    Command getCommand();
}
