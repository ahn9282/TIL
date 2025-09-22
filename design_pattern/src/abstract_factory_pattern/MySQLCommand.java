package abstract_factory_pattern;

public class MySQLCommand implements Command{
    @Override
    public void execute(String query) {
        System.out.println("Executing MySQL query: " + query);
    }
}
