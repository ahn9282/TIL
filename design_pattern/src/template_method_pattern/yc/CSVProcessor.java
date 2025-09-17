package template_method_pattern.yc;

public class CSVProcessor extends DataProcessor{
    @Override
    protected void loadData(String data) {
        System.out.println( "Loading CSV data...");
    }

    @Override
    protected boolean isValidData(String data) {
        return data != null && data.contains("CSV");
    }

    @Override
    protected void processData(String data) {
        System.out.println( "Processing CSV data");
    }

    @Override
    protected void saveData(String data) {
        System.out.println( "Saving CSV data to database");
    }
}
