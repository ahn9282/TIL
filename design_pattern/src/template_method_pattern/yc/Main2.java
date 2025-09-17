package template_method_pattern.yc;

public class Main2 {

    public static void main(String[] args) {
        DataProcessor csvProcessor = new CSVProcessor();
        csvProcessor.process("CSV data");

        System.out.println();

        JSONProcessor jsonProcessor = new JSONProcessor();
        jsonProcessor.process("XML data");
    }
}
