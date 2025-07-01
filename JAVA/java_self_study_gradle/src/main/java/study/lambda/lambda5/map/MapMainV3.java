package study.lambda.lambda5.map;

import java.util.List;

public class MapMainV3 {

    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "banana", "pineapple");
        List<Integer> map = GenericMapper.map(fruits, n -> n.length());

        System.out.println("map = " + map);

        List<String> uppercases = GenericMapper.map(fruits, n -> n.toUpperCase());
        System.out.println("map = " + map);

        List<Integer> integers = List.of(1, 2, 3, 4);
        List<String> map2 = GenericMapper.map(integers, n -> "*".repeat(n));
        System.out.println("map2 = " + map2);
    }
}
