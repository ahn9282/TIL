package study.lambda.lambda5.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MapMainV2 {

    public static void main(String[] args) {
        List<String> strings = List.of("1", "12", "123", "1234");

        List<Integer> mapToIntegers = mapStrings(strings, s -> Integer.valueOf(s));
        List<Integer> mapToLengths = mapStrings(strings, s -> s.length());

        System.out.println("mapToIntegers = " + mapToIntegers);
        System.out.println("mapToLengths = " + mapToLengths);
    }

    private static List<Integer> mapStrings(List<String> strings, Function<String, Integer> function) {

        List<Integer> list = new ArrayList<>();
        for (String string : strings) {
            list.add(function.apply(string));
        }
        return list;
    }
}
