package study.stream.start;

import java.util.List;
import java.util.stream.Stream;

public class StreamStartMain {
    public static void main(String[] args) {
        List<String> names = List.of("Apple", "Banana", "Berry", "Tomato");

        Stream<String> stream = names.stream();
        List<String> list = stream
                .filter(name -> name.startsWith("B"))
                .map(String::toUpperCase).toList();
        System.out.println("list = " + list);
        names.stream()
                .filter(name -> name.startsWith("B"))
                .forEach(name -> System.out.println("name : " + name.toUpperCase()));
    }
}
