package abstract_factory_pattern;

public class PostgreSQLConnection implements Connection {
    @Override
    public void open() {
        System.out.println( "Opening PostgreSQL connection");
    }

    @Override
    public void close() {
        System.out.println( "Closing PostgreSQL connection");
    }
}
