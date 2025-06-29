package study.lambda.lambda2.ex2;

import java.util.ArrayList;
import java.util.List;

public class FilterExample {
    public static List<Integer> filter(List<Integer> list, MyPredicate
            predicate) {
        List<Integer> result = new ArrayList<>();
        for (int val : list) {
            if (predicate.test(val)) {
                result.add(val);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        List<Integer> numbers = List.of(-3, -2, -1, 1, 2, 3, 5);
        System.out.println("원본 리스트: " + numbers);
    // 1. 음수(negative)만 뽑아내기
    // 코드 작성
        List<Integer> negatives = filter(numbers, x -> x < 0);
        System.out.println("negatives = " + negatives);

    // 2. 짝수(even)만 뽑아내기
    // 코드 작성
        List<Integer> evens = filter(numbers, x -> x % 2 == 0);
        System.out.println("evens = " + evens);

    }
}
