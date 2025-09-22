package abstract_factory_pattern;

public class Main2 {
    public static void main(String[] args) {
        DatabaseClient mysqlClient = new DatabaseClient(new MySQLFactory());
        mysqlClient.performDatabaseOperation();

        System.out.println("\nSwitching to PostgreSQL .... \n");

        DatabaseClient postgresClient = new DatabaseClient(new PostgreSQLFactory());
        postgresClient.performDatabaseOperation();
    }
}
