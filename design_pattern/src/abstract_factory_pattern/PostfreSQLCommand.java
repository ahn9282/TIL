package abstract_factory_pattern;

public class PostfreSQLCommand implements Command{
    @Override
    public void execute(String query) {
        System.out.println("Executing PostgreSQL query: " + query);
    }
}
