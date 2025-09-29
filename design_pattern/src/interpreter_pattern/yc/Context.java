package interpreter_pattern.yc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Context {
    private Map<String, List<Map<String, String>>> tables;

    public Context() {
        this.tables = new HashMap<>();
        ArrayList<Map<String, String>> users = new ArrayList<>();
        users.add(new HashMap<String, String>() {{
            put("id", "1");
            put("name", "John");
            put("age", "20");
        }});
        users.add(new HashMap<String, String>() {{
            put("id", "2");
            put("name", "Jane");
            put("age", "25");
        }});
        tables.put("users", users);
    }

    public List<Map<String, String>> getTable(String name) {
        return tables.get(name);
    }

    public void setTable(String name, List<Map<String, String>> table) {
        tables.put(name, table);
    }
}
