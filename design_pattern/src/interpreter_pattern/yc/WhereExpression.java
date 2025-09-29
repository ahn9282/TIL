package interpreter_pattern.yc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WhereExpression implements Expression2 {
    private String column;
    private String operator;
    private String value;
    private String tableName;

    public WhereExpression(String column, String operator, String value, String tableName) {
        this.column = column;
        this.operator = operator;
        this.value = value;
        this.tableName = tableName;
    }

    @Override
    public List<Map<String, String>> interpret(Context context) {
        ArrayList<Map<String, String>> result = new ArrayList<>();
        List<Map<String, String>> table = context.getTable(tableName);
        for (Map<String, String> row : table) {
            if (evaluate(row.get(column), operator, value)) {
                result.add(row);
            }
        }
        return result;
    }

    private boolean evaluate(String columnValue, String operator, String value) {
        switch (operator) {
            case "=":
                return columnValue.equals(value);
            case ">":
                return Integer.parseInt(columnValue) > Integer.parseInt(value);
            case "<":
                return Integer.parseInt(columnValue) < Integer.parseInt(value);
            default:
                return false;
        }

    }
}
