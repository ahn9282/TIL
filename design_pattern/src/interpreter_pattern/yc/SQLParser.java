package interpreter_pattern.yc;

import java.util.Arrays;
import java.util.List;

public class SQLParser {
    public static Expression2 parse(String query) {
        String[] parts = query.split("\\s+");
        if(!parts[0].equals("SELECT")) {
            throw new RuntimeException("Only SELECT statements are supported");
        }

        List<String> columns = Arrays.asList(parts[1].split(","));
        String tableName = parts[3];

        Expression2 whereClause = null;
        if(parts.length > 4 && parts[4].equals("WHERE")) {
            whereClause = new WhereExpression(parts[5], parts[6], parts[7], tableName);
        }
        return new SelectExpression(tableName, columns, whereClause);
    }
}
