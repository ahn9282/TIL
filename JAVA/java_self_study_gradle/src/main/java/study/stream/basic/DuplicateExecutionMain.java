package study.stream.basic;

import java.util.List;
import java.util.stream.Stream;

public class DuplicateExecutionMain {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);

        stream.forEach(System.out::println);
        try{
        stream.forEach(System.out::println);

        }catch(Exception e){
            e.printStackTrace();
        }
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        stream = list.stream();
        stream.forEach(System.out::println);
        Stream.of(list).forEach(System.out::println);
    }
}
