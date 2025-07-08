package study.stream.operation;

import org.assertj.core.internal.Numbers;
import org.w3c.dom.ls.LSOutput;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperationsMain {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("1. filter - 짝수만 선택");
        numbers.stream()
                .filter(n -> n %2 == 0)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("2. map - 각 숫자를 제곱");
        numbers.stream()
                .map(n -> n * n)
                .forEach(System.out::println);
        System.out.println(
        );

        System.out.println("3. distinct - 중복 제거");
        numbers.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println();
        System.out.println("4. sorted - 기본 정렬");
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 61, 2, 3);
        integerStream.sorted()
                .forEach(System.out::println);
        System.out.println();

        System.out.println("5. sorted with Comparator - 내림차순 정렬 ");
        Stream.of(2, 3, 5, 1, 23, 5, 65, 34)
                .sorted(Comparator.reverseOrder())
        .forEach(System.out::println);

        System.out.println();
        System.out.println("6. peek - 동작확인용");
        numbers.stream()
                .peek(n -> System.out.print("before : " + n + ", "))
                .map(n -> n * n)
                .peek(n -> System.out.print("after : " + n + ", "))
                .limit(5)
                .forEach(n -> System.out.println("최종 값 : " + n));

        System.out.println();
        System.out.println("7. limit - 처음 5개 요소만");
        numbers.stream()
                .limit(5)
                .forEach(n -> System.out.println(n + " "));
        System.out.println();

        System.out.println("8. skip - 처음 5개 요소를 건너 뛰기");
        numbers.stream()
                .skip(5)
                .forEach(n -> System.out.println(n + " "));
        System.out.println();

        System.out.println("9. takeWhile - 5보다 작은 동안만 선택");
        List<Integer> numbers2 = List.of(1, 2, 3, 4, 5, 1, 2, 3, 4);
        numbers2.stream()
                .takeWhile(n -> n < 5)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("10. drop While - 5보다 작은 동안 건너뛰기");
        numbers2.stream()
                .dropWhile(n -> n < 5)
                .forEach(System.out::println);


    }

}
