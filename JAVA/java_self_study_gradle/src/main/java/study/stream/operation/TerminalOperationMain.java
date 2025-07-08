package study.stream.operation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOperationMain {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        System.out.println("1. collect - List 수집");
        List<Integer> evenNumbers1 = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("짝수 리스트 = " + evenNumbers1);

        System.out.println("2. toList() - (Java 16+)");
        System.out.println();

        List<Integer> evenNumbers2 = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println("짝수 리스트 = " + evenNumbers2);

        System.out.println("3. toArray() - 배열로 변환");
        System.out.println();
        Integer[] evenNumbers3 = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toArray(Integer[]:: new);
        System.out.println("짝수 리스트 = " + evenNumbers2);
        System.out.println();

        System.out.println("4. forEach - 각 요소 처리");
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        System.out.println("5. count - 요소 개수");
        long count = numbers.stream()
                .filter(n -> n < 5)
                .count();
        System.out.println("count = " + count);
        System.out.println();

        System.out.println("6. reduce - 요소들의 합");
        Optional<Integer> reduce = numbers.stream()
                .reduce((a, b) -> a + b);
        System.out.println("합계 = " + reduce.get());
        System.out.println();

        System.out.println("7. min - 최솟값");
        Optional<Integer> min = numbers.stream()
                .min(Integer::compareTo);
        System.out.println("최솟값 = " + min.get());
        System.out.println();

        System.out.println("8. max - 최댓값");
        Optional<Integer> max = numbers.stream()
                .max(Integer::compareTo);
        System.out.println("최댓값 = " + max.get());
        System.out.println();

        System.out.println("9. find first - 첫 번째 요소");
        Integer first = numbers.stream()
                .filter(n -> n > 5)
                .findFirst().get();
        System.out.println("5보다 큰 첫 번째 숫자 " + first);
        System.out.println();

        //멀티 쓰레드 환경에서 바로 가져와서 성능 향상의 가능성 up
        System.out.println("10. find any - 아무 요소나");
        Integer any = numbers.stream()
                .filter(n -> n > 5)
                .findFirst().get();
        System.out.println("5보다 큰 아무나 " + any);
        System.out.println();

    System.out.println("11. any match - 조건을 만족하는 요소 존재 여부");
        boolean hasEven = numbers.stream()
                .anyMatch(n -> n > 5);
        System.out.println("짝수가 존재? :  " + any);
        System.out.println();

  System.out.println("11. all match - 조건을 만족하는 모든 요소 존재 여부");
        boolean allEven = numbers.stream()
                .allMatch(n -> n > 5);
        System.out.println("모두 짝수?  :  " + allEven);
        System.out.println();
        
  System.out.println("11. none match - 조건을 만족하는 모든 요소 미존재 여부");
        boolean allNegative = numbers.stream()
                .allMatch(n -> n > 5);
        System.out.println("모두 짝수 아님?  :  " + allNegative);
        System.out.println();

    }

}
