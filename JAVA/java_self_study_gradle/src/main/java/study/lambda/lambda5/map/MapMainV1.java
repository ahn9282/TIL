package study.lambda.lambda5.map;

import java.util.ArrayList;
import java.util.List;

public class MapMainV1 {

    public static void main(String[] args) {
        List<String> strings = List.of("1", "12", "123", "1234");

        List<Integer> numbers = mapStringToInteger(strings);
    }

    private static List<Integer> mapStringToInteger(List<String> strings) {
        List<Integer> list = new ArrayList<>();
        for (String string : strings) {
            list.add(Integer.valueOf(string));
        }
        return list;
    } private static List<Integer> mapStringToLength(List<String> strings) {
        List<Integer> list = new ArrayList<>();
        for (String string : strings) {
            list.add(string.length());
        }
        return list;
    }
}
