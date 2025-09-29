package interpreter_pattern.yc;

import java.util.List;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) {
        Context context = new Context();

        String query1 = "SELECT * FROM users";
        Expression2 expr1 = SQLParser.parse(query1);
        List<Map<String, String>> interpret = expr1.interpret(context);

        System.out.println("Result of query : " + query1);
        for (Map<String, String> row : interpret) {
            System.out.println("row = " + row);
        }


        String query2 = "SELECT name,age FROM users WHERE age > 27";
        Expression2 expr2 = SQLParser.parse(query2);
        List<Map<String, String>> result2 = expr2.interpret(context);

        System.out.println("\nResult of query : " + query2);
        for (Map<String, String> row : result2) {
            System.out.println("row = " + row);
        }
    }
}
