package study.lambda.lambda5.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class StringMapper {

    private static List<Integer> map(List<String> strings, Function<String, Integer> function) {

        List<Integer> list = new ArrayList<>();
        for (String string : strings) {
            list.add(function.apply(string));
        }
        return list;
    }
}
