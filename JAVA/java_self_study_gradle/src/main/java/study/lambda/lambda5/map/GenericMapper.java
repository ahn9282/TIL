package study.lambda.lambda5.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class GenericMapper {

    public static <T, R> List<R> map(List<T> strings, Function<T, R> function) {

        List<R> list = new ArrayList<>();
        for (T t : strings) {
            list.add(function.apply(t));
        }
        return list;
    }
}
