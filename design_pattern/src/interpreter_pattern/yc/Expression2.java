package interpreter_pattern.yc;

import java.util.List;
import java.util.Map;

public interface Expression2 {
    List<Map<String, String>> interpret(Context context);
}
