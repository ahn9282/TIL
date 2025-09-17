package template_method_pattern.yc;

public class JSONProcessor extends DataProcessor{
    @Override
    protected void loadData(String data) {
        System.out.println( "Loading JSON data...");
    }

    @Override
    protected boolean isValidData(String data) {
        return data != null && data.contains("JSON");
    }

    @Override
    protected void processData(String data) {
        System.out.println( "Processing JSON data");
    }

    @Override
    protected void saveData(String data) {
        System.out.println( "Saving JSON data to database");
    }
}
