package abstract_factory_pattern;

public class PostgreSQLResultSet implements ResultSet {
    @Override
    public void getResults() {
        System.out.println("getting results from PostgreSQL database.");
    }
}
