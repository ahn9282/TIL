package abstract_factory_pattern;

public class MySQLResultSet implements ResultSet{
    @Override
    public void getResults() {
        System.out.println("getting results from MySQL database.");
    }
}
