package interpreter_pattern.yc;

import java.util.*;

public class SelectExpression implements Expression2 {
    private String tableName;
    private List<String> columns;
    private Expression2 whereClause;

    public SelectExpression(String tableName, List<String> columns, Expression2 whereClause) {
        this.tableName = tableName;
        this.columns = columns;
        this.whereClause = whereClause;
    }

    @Override
    public List<Map<String, String>> interpret(Context context) {

        List<Map<String, String>> table = context.getTable(tableName);
        List<Map<String, String>> result = new ArrayList<>();

        for (Map<String, String> row : table) {
            Context rowContext = new Context();
            rowContext.setTable(tableName, Collections.singletonList(row));

            if (whereClause == null || !whereClause.interpret(rowContext).isEmpty()) {
                HashMap<String, String> newRow = new HashMap<>();

                for (String column : columns) {
                    if (column.equals("*")) {
                        newRow.putAll(row);
                    }else {
                        newRow.put(column, row.get(column));
                    }
                    result.add(newRow);
                }
            }
        }
        return result;
    }
}
